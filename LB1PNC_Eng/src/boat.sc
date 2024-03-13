;;; Sierra Script 1.0 - (do not remove this comment)
(script# 780)
(include game.sh)
(use Main)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Intrface)
(use User)

(public
	boat 0
)

(local
	creditShown
)
(instance boat of Room
	(properties
		picture 79
		style IRISOUT
	)
	
	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: FALSE)
		(theGame setCursor: 997)
			(if (== theCursor 999)
				(theGame setCursor: 997 (HaveMouse))
			)
			(if (== theCursor 998)
				(theGame setCursor: 997 (HaveMouse))
			)
		(Load VIEW 202)
		(Load FONT 41)
		(skiff
			view: 202
			loop: 0
			posn: 11 150
			setPri: 13
			setStep: 1 1
			setMotion: MoveTo 310 150 self
			setScript: Polling
			init:
		)
		(skiff cel: (- (NumCels skiff) 1))
		(if howFast
			(ripple
				view: 202
				loop: 1
				cel: 0
				setPri: 12
				setCycle: Forward
				setStep: 1 1
				init:
			)
			(reflection
				view: 202
				loop: 5
				posn: 143 134
				setCycle: Forward
				cycleSpeed: 2
				ignoreActors: TRUE
				init:
			)
			(fly1
				view: 202
				setLoop: 6
				cel: 0
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(fly2
				view: 202
				setLoop: 6
				cel: 1
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(fly3
				view: 202
				setLoop: 6
				cel: 2
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(fly4
				view: 202
				setLoop: 6
				cel: 3
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(fly5
				view: 202
				setLoop: 6
				cel: 4
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(fly6
				view: 202
				setLoop: 6
				cel: 5
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: TRUE
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
		)
		(picWindow left: 60 right: 260 bottom: 150 top: 40 init:)
		(Display 780 0
			p_at 100 30
			p_width 240
			p_color vWHITE
			p_back -1
			p_font SYSFONT
		)
		(cSound number: 5 loop: -1 play:)
	)
	
	(method (doit &tmp skiffX)
		(ripple
			posn: (+ (= skiffX (skiff x?)) 37) (+ (skiff y?) 1)
		)
		(if (and (not creditShown) (> skiffX 60))
			(Display 780 1
				p_at 61 44
				p_width 240
				p_color vBLACK
				p_back -1
				p_font 41
			)
			(Display 780 1
				p_at 60 43
				p_width 240
				p_color vWHITE
				p_back -1
				p_font 41
			)
			(= creditShown TRUE)
		)
	)
	
	(method (dispose)
		(DisposeScript WANDER)
		(super dispose:)
		(theGame setCursor: 997)
	)
	
	(method (handleEvent event)
		
			(if (== (event type?) evMOUSEBUTTON)
				(theGame setCursor: 997 (HaveMouse))
				(curRoom newRoom: 781)
			)
			(if (== theCursor 999)
				(theGame setCursor: 997 (HaveMouse))
			)
			(if (== theCursor 998)
				(theGame setCursor: 997 (HaveMouse))
			)				
		
		
		(cond
		((MousedOn boat event 0)
		
					(switch theCursor ;what cursor?
							(999 ;walk
								(event type: 1 claimed: 0) ;Don't claim event, let walk script take it
							)
							(997 ;sierra wait
								(event type: 1 claimed: 0) ;Don't claim event, let walk script take it
							)
							(998 ;look
								(event type: 1 claimed: 0) ;claim event so other scripts don't use it

							)	
					)
		)	
		)
				
		
		
		
		
		
		(if (event claimed?) (return))
		(switch (event type?)
			(keyDown
				(cond 
					(
						(or
							(== (event message?) `S)
							(== (event message?) `s)
						)
						(cls)
;;;						(event claimed: 1)
						(curRoom newRoom: 781)
					)
					(
						(or
							(== (event message?) ENTER)
							(== (event message?) SPACEBAR)
							(== (event message?) ESC)
						)
						(Bset fSkippedIntro)
					)
				)
			)
			(mouseDown
				;(Bset fSkippedIntro)
				(cls)
;;;				(event claimed: 1)
				
				(HandsOff)
				(theGame setCursor: 997)
				(curRoom newRoom: 781)
			)
		)
		(if (Btst fSkippedIntro)
			(cls)
;;;			(event claimed: TRUE)
			(theGame setCursor: 999 (HaveMouse))
			(curRoom newRoom: 44)
		)
	)
	
	(method (cue)
		(cls)
		(curRoom newRoom: 781)
	)
)

(instance Polling of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 50))
			)
			(1
				(if (skiff cel?)
					(skiff setCycle: BegLoop self)
				else
					(= cycles 1)
				)
			)
			(2
				(skiff setCycle: EndLoop self)
				(= state -1)
			)
		)
	)
)

(instance reflection of Prop)

(instance skiff of Actor)

(instance ripple of Actor)

(instance fly1 of Actor)

(instance fly2 of Actor)

(instance fly3 of Actor)

(instance fly4 of Actor)

(instance fly5 of Actor)

(instance fly6 of Actor)

(instance picWindow of Cage)
