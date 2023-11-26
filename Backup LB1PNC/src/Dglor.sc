;;; Sierra Script 1.0 - (do not remove this comment)
(script# 263)
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
	Dglor 0
)
(synonyms
	(actress body girl)
)

(instance Body of Prop
	(properties
		y 138
		x 207
		view 363
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dglor of Region
	
	(method (init)
		(proc415_1 4)
		(Body setPri: 8 init:)
;;;		(|= deadGuests deadGLORIA)
		(= deadGuests (| deadGuests $0004))
		(= global195 4)
		(self setScript: showCloseup)
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
							(DoVerb {examine gloria})
						)	
						(995
							(DoVerb {examine in gloria})
						)
						(996
							(DoVerb {converse gloria})
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
					((Said 'examine/boa')
						(Print 263 0)
					)
					((Said 'get/boa')
						(Print 263 1)
					)
					((Said '/actress>')
						(cond 
							((Said 'kill')
								(Print 263 2)
							)
							((Said 'kiss')
								(Print 263 3)
							)
							((Said 'embrace')
								(Print 263 4)
							)
							((Said 'get,drag,drag,press,move')
								(Print 263 5)
							)
							((Said 'examine')
								(Print 263 6)
							)
							((Said '(examine<in),search')
								(if (< (ego distanceTo: Body) 20)
									(if (== curRoomNum 24)
										(HandsOff)
										(self setScript: pickUp)
									else
										(Print 263 7)
									)
								else
									(NotClose)
								)
							)
							((Said 'help')
								(Print 263 8)
							)
							((Said 'converse')
								(Print 263 9)
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
				(HandsOff)
				(= seconds 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(myMusic play:)
				(Print 263 10
					#at 10 60
					#icon 363 1 0
					#mode teJustCenter
				)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setLoop: (ego loop?))
				(= cycles 2)
			)
			(1
				(ego
					view: 17
					cel: 0
					setMotion: 0
					ignoreControl: cWHITE
					setCycle: EndLoop self
				)
			)
			(2
				(Print 263 7)
				(= cycles 1)
			)
			(3
				(ego setCycle: BegLoop self)
			)
			(4
				(ego
					view: 0
					setLoop: -1
					observeControl: cWHITE
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)
