;;; Sierra Script 1.0 - (do not remove this comment)
(script# 56) ;OK
(include game.sh)
(use Main)
(use HighLite)
(use Intrface)
(use Motion)
(use Game)
(use System)


(public
	Room56 0
)
(synonyms
	(stair upstair)
)

(instance glow of HighLite)

(instance Room56 of Room
	(properties
		picture 56
	)
	
	(method (init)
		
		(= horizon 0)
		(= south (= east 55))
		(= global189 52)
		(super init:)
		(self setRegions: 242)
		(ego view: 7 init:)
		(if (== prevRoomNum 55)
			(ego loop: 1 posn: 307 188)
		else
			(self setScript: GoingDown)
		)
		(glow deltaX: 8 deltaY: 8 init:)
		
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 56 0)
		)
		(if (and (& (ego onControl:) cBLUE) (== script 0))
			(self setScript: GoingUp)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 214)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
				(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				(if (ClickedInRect 306 319 159 189 event) ;exit room right
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
		(super handleEvent: event)
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'examine[<around,at][/room]')
					(Print 56 0)
				)
				((Said 'examine/passage')
					(Print 56 1)
				)
				((or (Said 'examine/stair,stair') (Said 'examine<up'))
					(Print 56 2)
				)
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance GoingUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					illegalBits: 0
					setLoop: 1
					setMotion: MoveTo 177 122 self
				)
			)
			(1
				(if (& [global148 3] $0200)
					(ego loop: 2)
					(= state 3)
					(= cycles 2)
				else
					(ego
						view: 26
						loop: 0
						cel: 0
						setMotion: MoveTo 173 116 self
					)
				)
			)
			(2
				(ego loop: 1 cel: 0 cycleSpeed: 1 setCycle: EndLoop self)
			)
			(3
				(ego loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(4
				(HandsOn)
				(ego setLoop: -1 cycleSpeed: -1 illegalBits: cWHITE)
				(client setScript: 0)
				(curRoom newRoom: 57)
			)
		)
	)
)

(instance GoingDown of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					posn: 178 116
					illegalBits: 0
					setLoop: 0
					setMotion: MoveTo 238 185 self
				)
			)
			(1
				(HandsOn)
				(ego setLoop: -1 illegalBits: cWHITE)
				(client setScript: 0)
			)
		)
	)
)
