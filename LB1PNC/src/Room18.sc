;;; Sierra Script 1.0 - (do not remove this comment)
(script# 18)
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
	Room18 0
)
(synonyms
	(garden bush)
)

(instance Room18 of Room
	(properties
		picture 18
	)
	
	(method (init)
		(= east 8)
		(= north 6)
		(= horizon 135)
		(super init:)
		(Thunder number: 17 loop: 0)
		(self setFeatures: House Gate)
		(if howFast
			(light1 init: setScript: showers)
			(light2 init:)
			(light3 init:)
		)
		(if (and (== currentAct 3) (== global115 0))
			(self setRegions: 203)
		)
		(switch prevRoomNum
			(17 (ego posn: 1 174))
			(12 (ego posn: 1 155))
			(6 (ego posn: 63 137))
			(24 (ego posn: 152 187))
			(23 (ego posn: 74 188))
			(8 (ego posn: 315 180 loop: 1))
			(65 (ego posn: 158 168))
		)
		(ego view: 0 illegalBits: cWHITE init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 18 0)
		)
		(if (& (ego onControl: FALSE) cGREEN)
			(curRoom newRoom: 65)
		)
		(if (== (ego edgeHit?) WEST)
			(if (< (ego y?) 170)
				(curRoom newRoom: 12)
			else
				(curRoom newRoom: 17)
			)
		)
		(if (== (ego edgeHit?) SOUTH)
			(if (< (ego x?) 120)
				(curRoom newRoom: 23)
			else
				(curRoom newRoom: 24)
			)
		)
		(super doit:)
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
		
				(if (== theCursor 998) ;look
		
				(if
					(and
						global208
						(DoVerb {ask})
						)
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return (event claimed?)))
				)
				)
		
		)
		
		
		
		
		
		
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(if
					(and
						global208
						(Said
							'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
						)
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return (event claimed?)))
				)
				(if (Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(Print 18 0)
						)
						((Said '<(in,through)/garden,archway')
							(Print 18 1)
						)
						((Said '/garden')
							(Print 18 2)
						)
						((Said '/path,(boulder<stepping)')
							(Print 18 3)
						)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(if (== n 51) ((ScriptID 208) keep: 0))
		(super newRoom: n)
	)
)

(instance showers of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(light1 setCycle: Forward)
				(light2 setCycle: Forward)
				(light3 setCycle: Forward)
				(= cycles 7)
			)
			(1
				(light1 setCycle: EndLoop)
				(light2 setCycle: EndLoop)
				(light3 setCycle: EndLoop self)
			)
			(2
				(Thunder loop: 1 play: self)
			)
			(3
				(if (< (Random 1 100) 25)
					(= state -1)
				)
				(= cycles 7)
			)
			(4
				(= state 2)
				(= seconds 5)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 84
		x 285
		view 118
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 78
		x 206
		view 118
		loop 1
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 88
		x 181
		view 118
		loop 2
		cel 1
	)
)

(instance Thunder of Sound)

(instance House of RFeature
	(properties
		nsTop 77
		nsLeft 14
		nsBottom 111
		nsRight 82
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/cabin'))
			(event claimed: TRUE)
			(Print 18 4)
		)
	)
)

(instance Gate of RFeature
	(properties
		nsTop 107
		nsLeft 170
		nsBottom 162
		nsRight 201
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'close/archway')
				(Print 18 5)
			)
			((Said 'open/archway')
				(Print 18 6)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/archway'))
				(event claimed: TRUE)
				(Print 18 7)
			)
		)
	)
)
