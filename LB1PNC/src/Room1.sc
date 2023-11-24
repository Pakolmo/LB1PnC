;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use DCIcon)
(use Wander)
(use Path)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room1 0
)

(local
	local0
	local1
	leftPts = [217 107 117 111 -50 119 -32768]
	rightPts = [117 111 217 107 365 116 -32768]
	local16
	local17
	local18
	temp7
)
(instance Room1 of Room
	(properties
		picture 1
	)
	
	(method (init)
		(= horizon 85)
		(= east 4)
		(= west 3)
		(= north 28)
		(super init:)
		(LoadMany SOUND 82 88)
		(LoadMany VIEW 6 13 9)
		(self setRegions: 205 207)
		(myMusic number: 88 loop: 0)
		(if howFast
			(Turtle setPri: 13 init: stopUpd: setScript: turtleScript)
			(Frog init: stopUpd: setScript: frogScript)
			(flyCage left: -2 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 7
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Fly2
				setLoop: 7
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Fly3
				setLoop: 7
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Fly4
				setLoop: 7
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Fly5
				setLoop: 7
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Fly6
				setLoop: 7
				cel: 5
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
			(Gator
				setLoop: 8
				setCycle: Forward
				setPri: 3
				moveSpeed: 1
				ignoreActors: TRUE
				init:
				setScript: gatorScript
			)
			(wave1
				ignoreActors: TRUE
				cycleSpeed: 2
				setCycle: Forward
				setPri: 2
				init:
			)
			(wave2
				ignoreActors: TRUE
				cycleSpeed: 2
				setCycle: Forward
				setPri: 2
				init:
			)
		else
			(wave1 addToPic:)
			(wave2 addToPic:)
		)
		(ego view: 0 posn: 131 88 illegalBits: cWHITE init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 1 0)
		)
		(if (== script 0)
			(if (& (ego onControl: 0) cGREEN)
				(Frog dispose:)
				(self setScript: fallLeft)
			)
			(if (& (ego onControl: 0) cCYAN)
				(Frog dispose:)
				(self setScript: fallRight)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript PATH)
		(DisposeScript WANDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)		
	
		
			(if (ClickedOnObj Frog (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(996
							
							(= temp7
												(Print
													{Frog}
													#button {converse} 1
													#button {kiss} 2	
						


												)
											)
											(switch temp7
												(1 
													(DoVerb {converse frog})
														
												)
						
										
												(2
													(DoVerb {kiss frog})
													
				
												)
												(else
						
													(event claimed: FALSE)
												)
											)
						)		
						
						(998	
							(Print 1 6)
						)
						(995
														(= temp7
												(Print
													{Frog}
													#button {capture} 1
													#button {kill} 2	
													#button {pat} 3							


												)
											)
											(switch temp7
												(1 
													(DoVerb {capture frog})
														
												)
						
										
												(2
													(DoVerb {kill frog})
													
				
												)
												(3
													(DoVerb {pat frog})
													)
												
												(else
						
													(event claimed: FALSE)
												)
											)
						)	(else
						
													(event claimed: FALSE)
												)
											)		
		
		
		
			)
		
			(if (ClickedOnObj Turtle (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(996
							
							(= temp7
												(Print
													{Turtle}
													#button {converse} 1
													#button {kiss} 2	
						


												)
											)
											(switch temp7
												(1 
													(DoVerb {converse turtle})
														
												)
						
										
												(2
													(DoVerb {kiss turtle})
													
				
												)
												(else
						
													(event claimed: FALSE)
												)
											)
						)		
						
						(998	
							(Print 1 6)
						)
						(995
														(= temp7
												(Print
													{turtle}
													#button {capture} 1
													#button {kill} 2	
													#button {pat} 3							


												)
											)
											(switch temp7
												(1 
													(DoVerb {capture turtle})
														
												)
						
										
												(2
													(DoVerb {kill turtle})
													
				
												)
												(3
													(DoVerb {pat turtle})
													)
												
												(else
						
													(event claimed: FALSE)
												)
											)
						)	(else
						
													(event claimed: FALSE)
												)
											)		
		
		
		
			)




			(if (ClickedOnObj Gator (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
												
						
						(995
							(= temp7
												(Print
													{Gator}
													#button {capture} 1
													#button {pat} 2	
													#button {kill}3

												)
											)
											(switch temp7
												(1 
													(DoVerb {capture alligator})
														
												)
						
										
												(2
													(DoVerb {pat alligator})
													
				
												)
												(3
													(DoVerb {kill alligator})
													
				
												)
												(else
													
													(event claimed: FALSE)
												)
											)
												
						
						
						)
						(998
							(DoVerb {examine alligator})
						)
						(996
								(= temp7
												(Print
													{Gator}
													#button {converse} 1
													#button {kiss} 2	

												)
											)
											(switch temp7
												(1 
													(DoVerb {converse alligator})
														
												)
						
										
												(2
													(DoVerb {kiss alligator})
													
				
												)
												(else
													
													(event claimed: FALSE)
												)
											)
						)
						(else
													
							(event claimed: FALSE)
								)
					)



			)

		
					(if (ClickedInRect 211 315 116 148 event) ;Boxes
					(event claimed: TRUE)
					(switch theCursor
												
						
						(998		
							(DoVerb {examine box})
						)
						(995
							(= temp7
												(Print
													{Box}
													#button {move} 1
													#button {Open} 2	

												)
											)
											(switch temp7
												(1 
													(DoVerb {move box})
														
												)
						
										
												(2
													(DoVerb {open box})
													
				
												)
												(else
													
													(event claimed: FALSE)
												)
											)
						)
						(else
													
							(event claimed: FALSE)
								)
					)



			)

					(if (ClickedInRect 0 8 40 69 event) ;exit room left
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (- (ego x?) 315) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)	
					(if (ClickedInRect 312 319 40 67 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (+ (ego x?) 315) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)				
		
		
		)
		
		
		)
		
		

		
		
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'move/box')
					(Print 1 1)
				)
				((Said 'open,(examine<in)/box')
					(Print 1 2)
				)
				((Said 'examine>')
					(cond 
						((Said '<below/dock')
							(Print 1 3)
						)
						((Said '[<around,at][/room,dock]')
							(Print 1 0)
						)
						((Said '/box')
							(Print 1 4)
						)
					)
				)
				((Said 'get/box')
					(Print 1 1)
				)
			)
		)
	)
	
	(method (newRoom n)
		(if (not script)
			(super newRoom: n)
		)
	)
)

(instance fallLeft of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					view: 6
					cel: 0
					loop: 1
					illegalBits: 0
					setCycle: EndLoop self
				)
			)
			(1
				(ego cel: 0 loop: 3 cycleSpeed: 0 setCycle: Forward)
				(= seconds 2)
			)
			(2
				(= local16 (/ (- (ego y?) 90) 11))
				(= local17 (/ (- (ego y?) 90) 11))
				(ego
					cel: 0
					setLoop: 5
					cycleSpeed: 0
					setStep: 8 10
					setMotion: MoveTo (- (ego x?) local17) (+ (ego y?) local16)
					setCycle: EndLoop self
				)
				(Splash number: 82 loop: 1 priority: 3 play:)
			)
			(3
				(ego
					view: 13
					setLoop: 3
					cel: 0
					y: (+ (ego y?) 18)
					setMotion: 0
					cycleSpeed: 3
					setCycle: EndLoop self
				)
			)
			(4
				(myIcon init:)
				(= cIcon myIcon)
				(= deathLoop 0)
				(= deathCel 0)
				(= cyclingIcon TRUE)
				(EgoDead 1 5)
				(client setScript: 0)
			)
		)
	)
)

(instance fallRight of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					view: 6
					setLoop: 0
					cel: 0
					illegalBits: 0
					setCycle: EndLoop self
				)
			)
			(1
				(ego cel: 0 setLoop: 2 cycleSpeed: 0 setCycle: Forward)
				(= seconds 2)
			)
			(2
				(ego
					setPri: 3
					cel: 0
					setLoop: 4
					cycleSpeed: 0
					setStep: 8 10
					setMotion: MoveTo (+ (ego x?) 34) (+ (ego y?) 25)
					setCycle: EndLoop self
				)
				(Splash number: 82 loop: 1 priority: 2 play:)
			)
			(3
				(ego
					view: 13
					setLoop: 2
					cel: 0
					setMotion: 0
					cycleSpeed: 3
					setCycle: EndLoop self
				)
			)
			(4
				(myIcon init:)
				(= cIcon myIcon)
				(= deathLoop 0)
				(= deathCel 0)
				(= cyclingIcon TRUE)
				(EgoDead 1 5)
				(client setScript: 0)
			)
		)
	)
)

(instance gatorScript of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local1
					(0
						(Gator setLoop: 8 setMotion: leftPath self)
						(= local1 1)
					)
					(1
						(Gator setLoop: 9 setMotion: rightPath self)
						(= local1 0)
					)
				)
			)
			(1
				(= state -1)
				(= seconds (Random 15 25))
			)
		)
	)
)

(instance turtleScript of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(Turtle setCycle: EndLoop self)
			)
			(2
				(Turtle dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance frogScript of Script
	
	(method (doit)
		(super doit:)
		(if (and (== state 3) (< (Random 1 100) 40))
			(if (< local0 2)
				(myMusic loop: 1 play:)
				(++ local0)
			else
				(= local0 0)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
				(++ local0)
			)
			(1
				(myMusic loop: 1 priority: 2 play:)
				(Frog setCycle: EndLoop self)
			)
			(2
				(Frog posn: (Random 1 140) (Random 118 199) hide:)
				(= cycles 19)
			)
			(3
				(Frog loop: 6 illegalBits: cBLACK setCycle: BegLoop self show:)
			)
			(4
				(Frog loop: 5 setCycle: Forward)
				(= seconds (Random 3 16))
			)
			(5
				(Frog loop: 6 setCycle: EndLoop self)
			)
			(6
				(Frog posn: (Random 1 140) (Random 118 199) hide:)
				(= state 2)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 652
		cycleSpeed 16
	)
)

(instance wave1 of Prop
	(properties
		y 123
		x 261
		view 101
	)
)

(instance wave2 of Prop
	(properties
		y 186
		x 260
		view 101
		loop 1
		cel 2
		priority 14
	)
)

(instance Turtle of Prop
	(properties
		y 187
		x 61
		view 101
		loop 2
	)
)

(instance Frog of Actor
	(properties
		y 123
		x 74
		view 101
		loop 3
		priority 8
	)
	
	(method (handleEvent)
		(cond 
			((Said 'examine/frog,turtle')
				(Print 1 6)
			)
			((Said 'capture,get/frog,turtle')
				(Print 1 7)
			)
			((Said 'converse/frog,turtle')
				(Print 1 8)
			)
			((Said 'kiss/frog,turtle')
				(Print 1 9)
			)
			((Said 'kill/frog,turtle')
				(Print 1 7)
			)
			((Said 'pat/frog,turtle')
				(Print 1 10)
			)
		)
	)
)

(instance Gator of Actor
	(properties
		y 116
		x 360
		view 101
	)
	
	(method (handleEvent event)
		(if (not (self mover?)) (return))
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/alligator'))
				(event claimed: TRUE)
				(Print 1 11)
			)
			((Said '/alligator>')
				(cond 
					((Said 'feed')
						(Print 1 12)
					)
					((Said 'get,capture')
						(Print 1 13)
					)
					((Said 'pat')
						(Print 1 14)
					)
					((Said 'converse')
						(Print 1 15)
					)
					((Said 'kiss')
						(Print 1 16)
					)
					((Said 'hit,kill')
						(Print 1 17)
					)
				)
			)
			(
				(or
					(Said 'feed,deliver,hold/*[/alligator]')
					(Said 'feed,deliver,hold/*<alligator')
				)
				(if (and theInvItem haveInvItem)
					(Print 1 12)
				else
					(DontHave)
				)
			)
		)
	)
)

(instance Fly of Actor
	(properties
		y 123
		x 74
		view 101
	)
)

(instance Fly2 of Actor
	(properties
		y 179
		x 97
		view 101
	)
)

(instance Fly3 of Actor
	(properties
		y 139
		x 107
		view 101
	)
)

(instance Fly4 of Actor
	(properties
		y 123
		x 124
		view 101
	)
)

(instance Fly5 of Actor
	(properties
		y 159
		x 97
		view 101
	)
)

(instance Fly6 of Actor
	(properties
		y 139
		x 147
		view 101
	)
)

(instance myMusic of Sound)

(instance Splash of Sound)

(instance flyCage of Cage)

(instance leftPath of Path

	(method (at n)
		(return [leftPts n])
	)
)

(instance rightPath of Path
	
	(method (at n)
		(return [rightPts n])
	)
)
