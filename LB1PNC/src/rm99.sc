;;; Sierra Script 1.0 - (do not remove this comment)
(script# 99)
(include game.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use Menu)
(use User)
(include sci.sh)

(public
	rm99 0
)

(local
	doneTime
)
(instance Speedy of Actor)

(instance rm99 of Room
	(properties
		picture 992
		style IRISIN
	)
	
	(method (init)
		(HandsOff)
		(theGame setCursor: 997 (HaveMouse))
		(TheMenuBar state: FALSE)
;;;		(SetCursor 993)		
		(super init:)
		(User canControl: FALSE canInput: FALSE)
		(theGame setCursor: 997 (HaveMouse))
		(= howFast -1)
		(if (!= possibleScore 1)
			(Load rsVIEW 899)
			(LoadMany 143 409)
		)
		(Speedy
			view: 991
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Forward
			init:
		)
		(theGame setSpeed: 0)
	)
	
	(method (doit)
		(super doit:)
		(if (== howFast -1)
			(if (== (++ machineSpeed) 1)
				(= doneTime (+ 60 (GetTime)))
			)
			(if (< doneTime (GetTime))
				(cond 
					((<= machineSpeed 40)
						(= howFast 0)
					)
					((<= machineSpeed 70)
						(= howFast 1)
					)
					(else
						(= howFast 2)
					)
				)
				(= howFast medium)
				(theGame setSpeed: 6)

				(HandsOn)
				(theGame setCursor: 997 (HaveMouse))					
				(if
					(and
						(not possibleScore)
						(not (StrCmp {zz} (+ version 7)))
					)
					(self setScript: (ScriptID 409 0))
				else
					(curRoom newRoom:
						(switch possibleScore
							(1 44) ;44
							(else  414)
						)
					)
				)
			)
		)
	)
)
