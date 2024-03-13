;;; Sierra Script 1.0 - (do not remove this comment)
(script# 273)
(include game.sh)
(use Main)
(use Intrface)
(use FndBody)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Dfifi 0
)
(synonyms
	(butler fellow)
	(fifi body girl)
)

(local
	[local0 2]
	temp7
)
(instance Body of Prop
	(properties
		y 90
		x 154
		view 443
		loop 1
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/fifi,butler,people')
			)
			(event claimed: TRUE)
			(Print 273 0)
		)
	)
)

(instance mySound of Sound
	(properties
		number 99
		priority 1
		loop -1
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dfifi of Region
	
	(method (init)
		(proc415_1 16)
		(Body ignoreActors: TRUE init: stopUpd:)
		(= gDoor_2 mySound)
		(= global195 1040)
	)
	
	(method (doit)
		(if (and (not script) (> (ego x?) 64))
			(self setScript: showCloseup)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
					(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					
							(if (ClickedOnObj Body (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
									(= temp7

								(PrintSpecial
									{Examinar}
									#button {Fifi} 1
									#button {Jeeves} 2
									
;;;									{Examine}
;;;									#button {Fifi} 1
;;;									#button {Jeeves} 2							
								)
							)
							(switch temp7
								(1
								    ;(DoVerb {latch elevator})
								    (DoVerb {Examine Fifi})
								)
								(2
									;(DoVerb {unbar elevator})
									(DoVerb {Examine Jeeves})
								)
								(else
									(event claimed: FALSE)
								)
							)
						

					
					)
						
						(995
							(= temp7

								(PrintSpecial
									{Registrar}
									#button {Fifi} 1
									#button {Jeeves} 2
									
;;;									{Search}
;;;									#button {Fifi} 1
;;;									#button {Jeeves} 2							
								)
							)
							(switch temp7
								(1
								  
								    (DoVerb {search Fifi})
								)
								(2
								
									(DoVerb {search Jeeves})
								)
								(else
									(event claimed: FALSE)
								)
							)
						

					
					)
				
						(994
																(= temp7

								(PrintSpecial
									{Escuchar}
									#button {Fifi} 1
									#button {Jeeves} 2
									
;;;									{Hear}
;;;									#button {Fifi} 1
;;;									#button {Jeeves} 2							
								)
							)
							(switch temp7
								(1
								   
								    (DoVerb {Hear Fifi})
								)
								(2
								
									(DoVerb {Hear Jeeves})
								)
								(else
									(event claimed: FALSE)
								)
							)
						

					
					)
						
						(996
																(= temp7

								(PrintSpecial
									{Conversar}
									#button {Fifi} 1
									#button {Jeeves} 2
									
;;;									{Converse}
;;;									#button {Fifi} 1
;;;									#button {Jeeves} 2							
								)
							)
							(switch temp7
								(1
								    
								    (DoVerb {Converse Fifi})
								)
								(2
								
									(DoVerb {Converse Jeeves})
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
		
	
		
			)
					)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'get,drag,drag,press,move/fifi,butler,fifi')
						(Print 273 1)
					)
					((Said 'kill')
						(Print 273 2)
					)
					((Said '(examine<in),search/fifi,butler')
						(if (& (ego onControl: FALSE) cBROWN)
							(ego setScript: pickUp)
						else
							(NotClose)
						)
					)
					((Said 'examine/glass,drink')
						(Print 273 3)
					)
					((Said 'get/glass,drink')
						(Print 273 4)
					)
					((Said '/fifi>')
						(cond 
							((Said 'kiss')
								(Print 273 5)
							)
							((Said 'embrace')
								(Print 273 6)
							)
							((Said 'help')
								(Print 273 7)
							)
							((Said 'converse')
								(Print 273 8)
							)
						)
					)
					((Said '/butler>')
						(cond 
							((Said 'kiss')
								(Print 273 9)
							)
							((Said 'embrace')
								(Print 273 10)
							)
							((Said 'help')
								(Print 273 11)
							)
							((Said 'converse')
								(Print 273 12)
							)
						)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance showCloseup of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 99 loop: -1 play:)
				(gDoor setCycle: Forward init:)
;;;				(|= deadGuests deadFIFI)
				(= deadGuests (| deadGuests $0010))
				(Bset fSawFifiJeevesTogether)
				(HandsOff)
				(= seconds 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(myMusic play:)
				(Print 273 13
					#at 10 10
					#icon 443 0 0
					#mode teJustCenter
				)
				(= cycles 1)
			)
			(3
				(ego observeControl: cGREY)
				(HandsOn)
			)
		)
	)
)

(instance pickUp of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face ego Body)
				(= cycles 2)
			)
			(1
				(ego view: 17 cel: 0 setMotion: 0 setCycle: EndLoop self)
			)
			(2
				(Print 273 14)
				(= cycles 1)
			)
			(3
				(ego setCycle: BegLoop self)
			)
			(4
				(ego view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)
