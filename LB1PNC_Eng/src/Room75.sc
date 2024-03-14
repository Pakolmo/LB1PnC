;;; Sierra Script 1.0 - (do not remove this comment)
(script# 75)
(include game.sh)
(use Main)
(use ElevGate)
(use Intrface)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room75 0
)
(synonyms
	(newspaper letter)
	(room attic)
)

(local
	local0
	local1
	temp7
)
(procedure (LowPrint)
	(Print &rest
		#at 10 125
		#font 4
		#width 250
		#mode teJustCenter
		#dispose
	)
)

(instance Room75 of Room
	(properties
		picture 75
	)
	
	(method (init)
		(= currentPalette 0)
		(super init:)
		(if (not global388)
			(= global388
				(| (<< gameHours $0008) (* gameMinutes 15))
			)
		)
		(self setFeatures: Window1 Shaft Junk)
		(if (& deadGuests deadLILLIAN)
			(User canControl: FALSE canInput: TRUE)
			(= saveDisabled TRUE)
			(self setRegions: 290)
		else
			(head init: hide: stopUpd:)
			(arms init: hide: stopUpd:)
		)
		(if (!= prevRoomNum 66)
			(if (== prevRoomNum 74)
				(ego posn: 230 188)
			else
				(if (== prevRoomNum 42) (Bclr 46))
				(ego posn: 80 188)
			)
;;;			(ego view: 0 illegalBits: cWHITE)
			(ego view: 0 illegalBits: -32768)
		)
		(paper init: stopUpd:)
		((= gGate gate)
			chainID: chain
			elevatorID: elevator
			downID: down
			upID: up
			msgID:
				{What a dark and creepy attic! It helps to have the moonlight shining in through those big windows. 
				Among all the junk, a stack of old newspapers catches your eye.}
;;;			msgID:
;;;
;;;
;;;				{^Qu+ *tico tan oscuro y espeluznante! Ayuda tener la luz de la luna brillando a trav+s de esas grandes ventanas. 
;;;				
;;;				Entre todos los trastos, te llama la atenci/n una pila de peri/dicos viejos.}
			init:
		)
	)
	
	(method (doit)
		(if
			(and
				(not (& deadGuests deadLILLIAN))
				(not (& global109 $0010))
				(FirstEntry)
			)
			(Print 75 0)
		)
		(if (== (ego edgeHit?) SOUTH)
			(if (< (ego x?) 189)
				(curRoom newRoom: 76)
			else
				(curRoom newRoom: 74)
			)
		)
		(cond 
			((< (ego x?) 130)
				(= vertAngle 30)
			)
			((< (ego x?) 190)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 150)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 201)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
			(if (ClickedInRect 5 270 183 189 event) ;exit room down
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (ego x?) (+ (ego y?) 215))
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)	
					(if (ClickedInRect 0 7 112 189 event) ;exit room left
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
				

				(if (and (ClickedOnObj gate (event x?) (event y?))
						(== global111 75)
						(if (& global109 $0010)))
						
							(HandsOn)
;;;							(User mapKeyToDir: FALSE)
;;;							(User canControl: TRUE)
				(event claimed: TRUE)
				

					(switch theCursor
						(619
							(= temp7

								(PrintSpecial
;;;									{Ascensor}
;;;									#button {Bloquear} 1
;;;									#button {Desbloquear} 2
									
									{Elevator}
									#button {Lock} 1
									#button {Unlock} 2							
								)
							)
							(switch temp7
								(1
								    ;(DoVerb {latch elevator})
								    (DoVerb {lock elevator})
								)
								(2
									;(DoVerb {unbar elevator})
									(DoVerb {unlock elevator})
								)
								(else
									(event claimed: FALSE)
								)
							)
						

					
					)
					
						(998	
							(= temp7
								(PrintSpecial
									{ }
;;;									#button {Examinar Control} 1
;;;									#button {Examinar Agujero} 2	
;;;									#button {Examinar Eje} 3
									#button {Examine Control} 1
									#button {Examine Keyhole} 2	
									#button {Examine Shaft} 3							
								)
							)
							(switch temp7
								(1
								    (DoVerb {examine control})	
								)
								(2
									(DoVerb {examine keyhole})
								)
								(3
									(DoVerb {examine shaft})
								)						
								(else
									(event claimed: FALSE)
								)
							)
						)
;;;						(999	
;;;							(= temp7
;;;								(PrintSpecial
;;;									{Ascensor}
;;;									#button {Entrar} 1
;;;									#button {Salir} 2
;;;;;;									{Elevator}
;;;;;;									#button {Enter} 1
;;;;;;									#button {Exit} 2							
;;;								)
;;;							)
;;;							(switch temp7
;;;								(1
;;;								    (DoVerb {open elevator})
;;;								)
;;;								(2
;;;									(DoVerb {close elevator})
;;;								)
;;;								(else
;;;									(event claimed: FALSE)
;;;								)
;;;							)
;;;						)
						(995
							(= temp7
								(PrintSpecial
;;;									{Ascensor}
;;;									#button {Abrir} 1
;;;									#button {Cerrar} 2
;;;									#button {Arriba} 3
;;;									#button {Abajo} 4
									{Elevator}																	
									#button {Open} 1
									#button {Close} 2								
									#button {Press Up} 3
									#button {Press Down} 4
								)		

							)
							(switch temp7
								(1
								    (DoVerb {open elevator})
								)
								(2
									(DoVerb {close elevator})
								)
								(3
								    (DoVerb {move up})
								)
								(4
									(DoVerb {move down})
								)							
								(else
									(event claimed: FALSE)
								)
							)
						)
						(else
							(event claimed: FALSE)
;;;							(User mapKeyToDir: TRUE)
;;;							(User canControl: TRUE)
						)
					)
				)		


		
			(if (ClickedOnObj paper (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine newspaper})
						)
						(995 ;same
							(DoVerb {Examine newspaper})
						)						
						(else

						
							(event claimed: FALSE)
						)
					)

			)	
		
		
			
			(if (ClickedOnObj Window1 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine window})
						)			
						(else

						
							(event claimed: FALSE)
						)
					)

			)	
			
			(if (ClickedOnObj Shaft (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine elevator})
						)			
						(else

						
							(event claimed: FALSE)
						)
					)

			)		
		
			(if (ClickedOnObj Junk (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine garbage})
						)			
						(else

						
							(event claimed: FALSE)
						)
					)

			)			
		
		
		
			)
		)
		
		
		
		
		
		
		
		
		
		
		
		
		
		(super handleEvent: event)
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'get,move/box')
					(Print 75 1)
				)
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(if (& deadGuests deadLILLIAN)
								(Print 75 2)
							else
								(Print 75 0)
							)
						)
						((Said '<in/box')
							(Print 75 3)
						)
						((Said '/box')
							(Print 75 4)
						)
						((Said '<in/chest')
							(Print 75 5)
						)
						((Said '/chest')
							(Print 75 6)
						)
						((Said '[<at]/window')
							(Print 75 7)
						)
					)
				)
				((Said 'open>')
					(cond 
						((Said '/box')
							(Print 75 3)
						)
						((Said '/chest')
							(Print 75 5)
						)
					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance readNewspaper of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego illegalBits: 0 setMotion: MoveTo 32 127 self)
			)
			(1
				(ego
					view: 61
					cel: 0
					loop: 1
					cycleSpeed: 1
					setCycle: EndLoop self
				)
			)
			(2
				(paper hide: forceUpd:)
				(ego loop: 2 cel: 0)
				(head posn: (+ (ego x?) 4) (- (ego y?) 38) show:)
				(arms posn: (- (ego x?) 3) (- (ego y?) 26) show:)
				(= cycles 2)
			)
			(3
				(Print 75 8)
				(= cycles 1)
			)
			(4
				(++ local1)
				(head setCycle: Forward)
				(switch local1
					(1 (LowPrint 75 9))
					(2 (LowPrint 75 10))
					(3 (LowPrint 75 11))
				)
			)
			(5
				(cls)
				(if (< local1 3)
					(= state 3)
					(arms setCycle: EndLoop self)
				else
					(= cycles 1)
				)
			)
			(6
				(paper show: forceUpd:)
				(ego loop: 1)
				(ego cel: (ego lastCel:) setCycle: BegLoop self)
				(head hide: forceUpd:)
				(arms hide: forceUpd:)
			)
			(7
				(Print 75 12)
				(= local0 1)
				(HandsOn)
				(ego
					view: 0
					loop: 1
					cycleSpeed: 0
					illegalBits: cWHITE
					setCycle: Walk
				)
				(head dispose:)
				(arms dispose:)
				(client setScript: 0)
			)
		)
	)
	
	(method (handleEvent event)
		(if
			(and
				(not (event claimed?))
				(or
					(== (event type?) mouseDown)
					(== (event type?) keyDown)
					(== (event type?) direction)
				)
				(== state 4)
			)
			(if (!= (event type?) direction)
				(= seconds 0)
				(= cycles 1)
			)
			(event claimed: TRUE)
		)
	)
)

(instance paper of Prop
	(properties
		y 127
		x 17
		view 61
	)
	
	(method (handleEvent event)
		(if
			(or
				(Said 'get,read,examine/newspaper')
				(MousedOn self event shiftDown)
			)
			(event claimed: TRUE)
			(cond 
				((& global109 $0010)
					(Print 75 13)
				)
				(local0
					(Print 75 14)
				)
				((< (ego distanceTo: paper) 50)
					(Room75 setScript: readNewspaper)
				)
				(else
					(NotClose)
				)
			)
		)
	)
)

(instance head of Prop
	(properties
		view 61
		loop 3
		cycleSpeed 3
	)
)

(instance arms of Prop
	(properties
		view 61
		loop 4
		cycleSpeed 1
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 16
		nsLeft 97
		nsBottom 82
		nsRight 207
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {window})
		)
	)
)

(instance Shaft of RFeature
	(properties
		nsTop 52
		nsLeft 38
		nsBottom 113
		nsRight 66
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {elevator})
		)
	)
)

(instance Junk of RFeature
	(properties
		nsTop 30
		nsLeft 266
		nsBottom 129
		nsRight 319
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/garbage,possession,furniture')
			)
			(Print 75 15)
			(event claimed: TRUE)
		)
	)
)

(instance gate of ElevGate)

(instance chain of Actor)

(instance elevator of Actor
	(properties
		y -10 ;-10
	)
)

(instance down of View)

(instance up of View)
