;;; Sierra Script 1.0 - (do not remove this comment)
(script# 76)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room76 0
)
(synonyms
	(room attic)
)

(local
	local0
	temp7
)
(instance Room76 of Room
	(properties
		picture 76
	)
	
	(method (init)
		(= horizon 95)
		(= north 75)
		(= east 74)
		(= currentPalette 0)
		(super init:)
		(Load SOUND 117)
		(if (not global388)
			(= global388
				(| (<< gameHours $0008) (* gameMinutes 15))
			)
		)
		(switch currentAct

			(2 (= local0 1))
			(4 (= local0 2))
			(6 (= local0 4))
		)
		(self setFeatures: Junk)
		(trunk init: stopUpd:)
		(Elevator
			cel:
				(cond 
					((== global111 75) 1)
					((not (& global109 $0004)) 2)
					(else 3)
				)
			init:
			stopUpd:
		)
		(if (== prevRoomNum 75)
			(ego posn: 268 96)
		else
			(ego posn: 309 117)
		)
		(ego init:)
		(Killer init: hide:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 76 0)
		)
		(super doit:)
		(if
			(and
				(& (ego onControl: origin) cYELLOW)
				(not script)
				(not (Btst 46))
				(< currentAct 7)
			)
			(self setScript: Strangle)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		
				(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				
	
					(if (ClickedInRect 312 319 39 122 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (+ (ego x?) 70) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)				
				
				(if (and (ClickedOnObj trunk (event x?) (event y?)) 
					(== (event claimed?) FALSE) 
					local0)
					(event claimed: TRUE)
					(switch theCursor
						(995
							(= temp7
												(PrintSpecial
		
;;;													{Get}
;;;													#button {Cape} 1	
;;;													#button {Glove} 2	
;;;													#button {Boot} 3
;;;													#button {Hat} 4	
;;;													#button {Insignia} 5	
		
													{Coger}
													#button {Capa} 1
													#button {Guante} 2	
													#button {Bota} 3
													#button {Gorro} 4														
													#button {Insignia} 5
																									
												)
											)
											(switch temp7
												(1 
													(DoVerb {get cape})
												)
												(2 
													(DoVerb {get glove})
												)
												(3 
													(DoVerb {get boot})
												)
												(4 
													(DoVerb {get hat})
												)
												(5 
													(DoVerb {get insignia})
												)
																																				
												(else
													(event claimed: FALSE)
												)	
											)											
						)		
						(998
							(= temp7
												(PrintSpecial
		
;;;													{Examine}
;;;													#button {Cape} 1	
;;;													#button {Glove} 2	
;;;													#button {Boot} 3
;;;													#button {Hat} 4	
;;;													#button {Insignia} 5	
		
													{Examinar}
													#button {Capa} 1
													#button {Guante} 2	
													#button {Bota} 3
													#button {Gorro} 4														
													#button {Insignia} 5
																									
												)
											)
											(switch temp7
												(1 
													(DoVerb {examine cape})
												)
												(2 
													(DoVerb {examine glove})
												)
												(3 
													(DoVerb {examine boot})
												)
												(4 
													(DoVerb {examine hat})
												)
												(5 
													(DoVerb {examine insignia})
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




				(if (and (ClickedOnObj trunk (event x?) (event y?)) 
					(== (event claimed?) FALSE) 
					(not local0))
					(event claimed: TRUE)
					(switch theCursor
						(995	
		
								(= temp7
												(PrintSpecial
		
;;;													{ }
;;;													#button {Get box} 1
;;;													#button {Get chest} 2	

													{ }
													#button {Coger caja} 1
													#button {Coger cofre} 2	
																									
												)
											)
											(switch temp7
												(1 
													(DoVerb {get box})
														
												)
												(2 
													(DoVerb {get chest})
		
														
												)
												(else
													(event claimed: FALSE)
												)	
											)											
						)		
		
						(998
									
								(= temp7
												(PrintSpecial
		
;;;													{Chest}
;;;													#button {Search} 1
;;;													#button {Examine} 2	

													{Cofre}
													#button {Buscar} 1
													#button {Examinar} 2	
																									
												)
											)
											(switch temp7
												(1 
													(DoVerb {examine in chest})
														
												)
												(2 
													(DoVerb {examine chest})
		
														
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
		
				(if (and (ClickedOnObj Elevator (event x?) (event y?)) 
					(== (event claimed?) FALSE) )
					(event claimed: TRUE)
					(switch theCursor
						(998
								(event claimed: TRUE)
								(DoLook {elevator})		
						)
						(else
							(event claimed: FALSE)
						)
					)
				)		
				(if (and (ClickedOnObj Junk (event x?) (event y?)) 
					(== (event claimed?) FALSE) )
					(event claimed: TRUE)
					(switch theCursor
						(998
								(DoVerb {examine garbage})
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
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]') (Print 76 0))
							((Said '/garbage,possession') (Print 76 1))
							((Said '<in/box') (Print 76 2))
							((Said '/box') (Print 76 3))
							((Said '/dormer') (Print 76 4))
							((Said '/cloth') (Print 76 5))
							((Said '/possession,garbage') (Print 76 6))
							((Said '/window') (Print 76 7))
							((Said '/elevator')
								(if (== global111 curRoomNum)
									(Print 76 8)
								else
									(Print 76 9)
								)
							)
							(local0
								(cond 
									((Said '/cape')
										(switch local0
											(4 (Print 76 10))
											(else  (Print 76 11))
										)
									)
									((Said '/glove')
										(switch local0
											(4 (Print 76 12))
											(else  (Print 76 13))
										)
									)
									((Said '/boot')
										(switch local0
											(1 (Print 76 14))
											(else  (Print 76 15))
										)
									)
									((Said '/hat') (Print 76 16))
									((Said '/heel,insignia')
										(switch local0
											(1 (Print 76 17))
											(else  (Print 76 18))
										)
									)
								)
								(if (event claimed?) (Bset 46))
							)
							((Said '/cape,hat,heel') (Print 76 19))
							((Said '/glove,boot') (Print 76 20))
						)
					)
					((Said 'open>')
						(cond 
							((Said '/box') (Print 76 2))
							((Said '/chest') (Print 76 21))
						)
					)
					((Said 'get>')
						(cond 
							((Said '/cloth') (Print 76 22))
							((Said '/possession,garbage') (Print 76 22))
							(local0
								(cond 
									((Said '/cape') (Print 76 23))
									((Said '/glove') (Print 76 24))
									((Said '/hat') (Print 76 25))
									((Said '/boot') (Print 76 26))
								)
								(if (event claimed?) (Bset 46))
							)
						)
					)
					((Said 'wear,(attach<on)>')
						(cond 
							((Said '/cloth') (Print 76 27))
							(local0
								(cond 
									((Said '/cape') (Print 76 23))
									((Said '/glove') (Print 76 24))
									((Said '/hat') (Print 76 25))
									((Said '/boot') (Print 76 26))
								)
								(if (event claimed?) (Bset 46))
							)
						)
					)
					((Said 'close/chest') (Print 76 28))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance Strangle of Script

	(method (doit)
		(super doit:)
		(if
			(and
				(== (myMusic prevSignal?) -1)
				(== state 3)
				(== (ego cel?) (- (NumCels ego) 1))
			)
			(myMusic prevSignal: 0)
			(= cycles 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(myMusic prevSignal: 0 number: 117 loop: 1 play:)
				(Killer show: setCycle: EndLoop self)
			)
			(1
				(Killer loop: 1 cycleSpeed: 1 setCycle: Forward)
				(ego cel: 0 hide:)
				(= cycles 5)
			)
			(2
				(Killer loop: 4)
				(= seconds 3)
			)
			(3
				(Killer loop: 2 cel: 0 setCycle: EndLoop)
				(ego
					show:
					view: 62
					loop: 3
					cel: 0
					posn: 155 92
					setCycle: EndLoop
				)
			)
			(4
				(= cIcon 62)
				(= deathLoop 5)
				(= deathCel 0)
				(EgoDead 76 29)
				(client setScript: 0)
			)
		)
	)
)

(instance trunk of Prop
	(properties
		y 157
		x 72
		view 176
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get,move/box') (Print 76 30))
			((Said 'get,move/chest') (Print 76 31))
			(
				(or
					(Said 'search,(examine<in)/chest')
					(Said 'search,(examine<in)/cloth')
				)
				(if (< (ego distanceTo: trunk) 30)
					(if (not local0)
						(Print 76 32)
					else
						(Bset 46)
						(switch local0
							(1 (Printf 76 33 76 32 76 34))
							(2
								(Printf 76 35 76 32 76 34 76 36)
							)
							(else 
								(Printf 76 35 76 32 76 34 76 37)
							)
						)
					)
				else
					(NotClose)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/chest'))
				(event claimed: TRUE)
				(Print 76 38)
			)
		)
	)
)

(instance Elevator of Prop
	(properties
		y 50
		x 271
		view 176
		cel 1
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
			(Print 76 38)
			(event claimed: TRUE)
		)
	)
)

(instance Killer of Prop
	(properties
		y 74
		x 177
		view 62
	)
)

(instance myMusic of Sound)
