;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Menu)
(use Actor)
(use System)
(use Invent)
(use Sound)

(local
	[inputLine 23]
	inputLen
)

(class User of Object
	(properties
		alterEgo 0
		canInput 0
		controls 0
		echo 32
		prevDir 0
		prompt {Enter input}
		inputLineAddr 0
		x -1
		y -1
		blocks 1
		mapKeyToDir 1
	)

	(method (init inLine length)
		(= inputLineAddr (if argc inLine else @inputLine))
		(= inputLen (if (== argc 2) length else 45))
	)

	(method (doit)
		(self handleEvent: (Event new:))
	)

	(method (handleEvent event &tmp evType dir)
		(if (event type:)
			(= lastEvent event)
			(= evType (event type:))
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if TheMenuBar
				;(TheMenuBar handleEvent: event evType)
			)
			(GlobalToLocal event)
			(if (not (event claimed:))
				(theGame handleEvent: event evType)
			)
			;; This crashes for some unknown reason
			;; specifically the (gCast contains: alterEgo) check seems to cause crash			
			(if
				(and
					controls
					(not (event claimed:))
					(cast contains: alterEgo) ;not gCast
				)
				(alterEgo handleEvent: event evType)
			)
			
			(if
				(and
					canInput
					(not (event claimed:))
					(== (event type:) evKEYBOARD)
					(or
						(== (event message:) echo)
						(<= KEY_SPACE (event message:) $00ff)
					)
					(self getInput: event)
					(Parse @inputLine event)
				)
				(event type: evSAID)
			)
			(if (== (event type:) evSAID)
				(if saidsAnchor
					(saidsAnchor setScript: (ScriptID 413 0)) ; isInvItem
					((saidsAnchor script:) handleEvent: event)
				)
				(if (not (event claimed:))
					(self said: event)
				)
			)
			(if (== (event modifiers?) 999)
        	(StrCpy @inputLine (event message?))
			(if (Parse @inputLine event)
				(event type:evSAID)
				(self said:event)
			)
        )
		)
;;;		(event dispose:)
		(= lastEvent 0)
	)

	(method (getInput event &tmp temp0 temp1)
		(if (!= (event type:) 4)
			(= inputLine 0)
		)
		(if (!= (event message:) echo)
			(Format @inputLine 996 0 (event message:)) ; "%c"
		)
		(if (== (event message:) echo)
			(= temp1 (Print prompt #edit @inputLine inputLen #at x y #button {Return} 1))
		else
			(= temp1 (GetInput @inputLine inputLen prompt 67 x y))
		)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)

	(method (said event)
		(if useSortedFeatures
			(__proc984_0 alterEgo sortedFeatures cast features)
		else
			(sortedFeatures add: cast features)
		)
		(if TheMenuBar
			(sortedFeatures addToFront: TheMenuBar)
		)
		(sortedFeatures addToEnd: theGame handleEvent: event release:)
		(if (and (== (event type:) 128) (not (event claimed:)))
			(theGame pragmaFail: @inputLine)
		)
	)
)

(class Ego of Actor
	(properties
		signal 8192
		edgeHit 0
	)

	(method (init)
		(super init:)
		(if (not cycler)
			(self setCycle: Walk)
		)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x 0) 4)
				((<= y (curRoom horizon:)) 1)
				((>= x 319) 2)
				((>= y 189) 3)
				(else 0)
			)
		)
	)

	(method (get what &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			((inventory at: [what i]) moveTo: self)
		)
	)

	(method (put what recipient)
		(if (self has: what)
			((inventory at: what) moveTo: (if (== argc 1) -1 else recipient))
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (inventory at: what))
			(theItem ownedBy: self)
		)
	)

	(method (handleEvent event &tmp temp0 temp5)
		(if (not (super handleEvent: event))
			(switch (event type:)
				(evMOUSEBUTTON
					(if
						(and
							(not (& (event modifiers:) emSHIFT))
							(User controls:)
							(== theCursor 999) ;only walk if cursor is 999
						)
						(self setMotion: MoveTo (event x:) (event y:))
						(User prevDir: 0)
						(event claimed: 1)

					)
					; click on ego handled in PNCmenu, script 950
;;;					(if (ClickedOnObj Ego (event x?) (event y?))
;;;						(event claimed: TRUE)
;;;						(switch theCursor	
;;;							(998 		
;;;								(event claimed: 1)
;;;								(= temp5 (Sound pause: 1))
;;;								(Inv showSelf: 888)
;;;								(Sound pause: temp5)
;;;								(DoUseItem useInvItem event)	
;;;							)
;;;							(995
;;;								(event claimed: 1)
;;;								(DoVerb {Smell room})
;;;							)
;;;							(else
;;;							
;;;								(event claimed: FALSE)
;;;							)
;;;						)
;;;					)
				)
				($0040 ; direction
					(if
						(and
							(== (= temp0 (event message:)) (User prevDir:))
							(IsObject mover)
						)
						(= temp0 JOY_NULL)
					)
					(User prevDir: temp0)
					(self setDirection: temp0)
					(event claimed: 1)
				)
			)
		)
		(event claimed:)
	)
)


