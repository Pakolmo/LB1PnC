;;; Sierra Script 1.0 - (do not remove this comment)
(script# 29)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room29 0
)

(local
	local0
	temp7
)
(instance Room29 of Room
	(properties
		picture 29
	)
	
	(method (init)
		(= horizon 84)
		(= east 30)
		(= west 28)
		(= north 23)
		(super init:)
		(if howFast
			(owlHead setScript: owl init:)
			(owlBody init: stopUpd:)
			(star1 cycleSpeed: 2 setCycle: Forward init:)
			(star2 init: setScript: twinkle)
		else
			(owlBody init: stopUpd:)
			(owlHead loop: 4 cel: 2 addToPic:)
		)
		(self setRegions: 207 405 setFeatures: owlBody)
		(if (and (== currentAct 3) (< global115 6))
			(self setRegions: 203)
		)
		(switch prevRoomNum
			(23 (ego posn: 151 118))
			(24 (ego posn: 255 125))
		)
		(ego view: 0 illegalBits: cWHITE init:)
		(HandsOn)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 29 0)
		)
		(if (& (ego onControl: 0) cBLUE)
			(curRoom newRoom: 23)
		)
		(if (& (ego onControl: 0) cGREEN)
			(curRoom newRoom: 24)
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
							
		
			(if (ClickedOnObj owlHead (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998	
							(DoVerb {examine owl})
						)
						(996
							(DoVerb {converse owl})
						)
						(995
								(= temp7
												(PrintSpecial
													{Owl}
													#button {Deliver} 1
													#button {Feed} 2								
													#button {Hold} 3
													#button {Capture} 4

												)
											)
											(switch temp7
												(1 							
													(DoVerb {deliver owl})	
												)
												(2
													(DoVerb {feed owl})
												)
												(3
													(DoVerb {hold owl})
												)	
												(4
													(DoVerb {capture owl})
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
				
		
		
				(if (ClickedOnPicView owlBody (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998	
							(Print 29 7)
							(event claimed: TRUE)
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
			(if (and (== (event type?) saidEvent) (Said 'examine>'))
				(cond 
					((Said '[<around,at][/room]')
						(Print 29 0)
					)
					((Said '/cabin,mansion')
						(Print 29 1)
					)
					((Said '/path')
						(Print 29 2)
					)
					((Said '/gazebo')
						(Print 29 3)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance twinkle of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(star2 setCycle: EndLoop self)
			)
			(1
				(if (< (Random 1 100) 35)
					(= state -1)
				else
					(= state 0)
				)
				(= seconds (Random 7 15))
			)
		)
	)
)

(instance owl of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 7)))
			(1
				(if (== (owlHead cel?) 0)
					(owlHead setCycle: EndLoop self)
					(= local0 (Random 0 3))
				else
					(owlHead setCycle: BegLoop self)
					(= state -1)
				)
			)
			(2
				(if local0
					(= cycles 1)
				else
					(= seconds (Random 2 5))
				)
			)
			(3
				(if local0
					(owlHead loop: 4)
					(= seconds (Random 2 5))
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(owlHead loop: 3)
				(= cycles 5)
			)
			(5
				(if (-- local0)
					(= state 2)
				else
					(= state 0)
				)
				(= cycles 1)
			)
		)
	)
)

(instance star1 of Prop
	(properties
		y 34
		x 294
		view 107
		loop 1
	)
)

(instance star2 of Prop
	(properties
		y 13
		x 117
		view 107
		loop 2
	)
)

(instance owlHead of Prop
	(properties
		y 58
		x 130
		view 125
		loop 3
		priority 14
		signal fixPriOn
		cycleSpeed 2
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'deliver,feed,hold>')
				(if (or (Said '/*<owl') (Said '/owl') (Said '/*/owl'))
					(if theInvItem
						(if haveInvItem
							(Print 29 4)
						else
							(DontHave)
						)
					else
						(Print 29 4)
					)
				)
			)
			((Said 'converse/owl')
				(Print 29 5)
			)
			((Said 'capture,get/owl')
				(Print 29 6)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/owl'))
				(Print 29 7)
				(event claimed: TRUE)
			)
		)
	)
)

(instance owlBody of Prop
	(properties
		y 82
		x 122
		view 125
		loop 4
		cel 1
		priority 15
		signal fixPriOn
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(Print 29 7)
			(event claimed: TRUE)
		)
	)
)
