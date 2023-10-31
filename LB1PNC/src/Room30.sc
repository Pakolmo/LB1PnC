;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include game.sh)
(use Main)
(use Intrface)
(use DCIcon)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room30 0
)

(local
	local0
	
)
(instance Room30 of Room
	(properties
		picture 30
	)
	
	(method (init)
		(= horizon 84)
		(= west 29)
		(= north 8)
		(super init:)
		(Load SOUND 82)
		(self setRegions: 205 207 setFeatures: House)
		(Load VIEW 35)
		(Thunder number: 17 loop: 0)
		(if howFast
			(reflect1 cycleSpeed: 1 setCycle: Forward init:)
			(reflect2
				ignoreActors: TRUE
				cycleSpeed: 1
				setCycle: Forward
				init:
			)
			(light1 init: setScript: showers)
			(light2 init:)
			(light3 init:)
			(light4 init:)
			(flyCage left: 160 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 6
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setCycle: Forward
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly2
				setLoop: 6
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setCycle: Forward
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly3
				setLoop: 6
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setCycle: Forward
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly4
				setLoop: 6
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setCycle: Forward
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly5
				setLoop: 6
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setCycle: Forward
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
		else
			(reflect1 addToPic:)
			(reflect2 addToPic:)
		)
		(if (and (== currentAct 3) (< global115 5))
			(self setRegions: 203)
		)
		(switch prevRoomNum
			(24 (ego posn: 26 112))
			(8 (ego posn: 122 112 loop: 2))
		)
		(ego view: 0 init:)
		(HandsOn)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 30 0)
		)
		(if (& (ego onControl: 0) cCYAN)
			(curRoom newRoom: 24)
		)
		(if (and (& (ego onControl: origin) cBLUE) (== local0 0))
			(= local0 1)
			(self setScript: sink)
		)
		(if (and (& (ego onControl: 0) cGREEN) (== local0 0))
			(curRoom newRoom: 8)
		)
		(super doit:)
	)
	
	(method (dispose)
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
		
		
		
						(if (ClickedOnObj House (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(Print 30 2)
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
			(if
				(and
					(== (event type?) saidEvent)
					(Said 'examine>')
					(Said '[<around,at][/room][/!*]')
				)
				(Print 30 0)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance showers of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (= state 3)))
			(1
				(light1 setCycle: Forward)
				(light2 setCycle: Forward)
				(light3 setCycle: Forward)
				(light4 setCycle: Forward)
				(= cycles 7)
			)
			(2
				(light1 setCycle: EndLoop)
				(light2 setCycle: EndLoop)
				(light3 setCycle: EndLoop)
				(light4 setCycle: EndLoop self)
			)
			(3 (Thunder loop: 1 play: self))
			(4
				(if (< (Random 1 100) 25)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance sink of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Room30 south: 0 north: 0)
				(HandsOff)
				(myMusic number: 82 loop: 1 play:)
				(ego
					view: 35
					cel: 0
					xStep: 1
					cycleSpeed: 3
					setMotion:
						MoveTo
						(switch (ego loop?)
							(0 (+ (ego x?) 10))
							(1 (- (ego x?) 10))
							(else  (ego x?))
						)
						(switch (ego loop?)
							(2 (+ (ego y?) 3))
							(3 (- (ego y?) 3))
							(else  (ego y?))
						)
					cycleSpeed: 1
					setCycle: EndLoop self
				)
			)
			(1
				(ego hide:)
				(= seconds 3)
			)
			(2
				(= cIcon myIcon)
				(= deathLoop 5)
				(= deathCel 0)
				(= cyclingIcon TRUE)
				(EgoDead 30 1)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 55
		x 296
		view 130
		loop 2
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 102
		x 294
		view 130
		loop 3
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 45
		x 21
		view 130
		loop 4
		cel 1
	)
)

(instance light4 of Prop
	(properties
		y 77
		x 53
		view 130
		loop 5
		cel 1
	)
)

(instance reflect1 of Prop
	(properties
		y 94
		x 224
		view 130
	)
)

(instance reflect2 of Prop
	(properties
		y 186
		x 226
		view 130
		loop 1
	)
)

(instance Thunder of Sound)

(instance myMusic of Sound)

(instance myIcon of DCIcon
	(properties
		view 13
		loop 5
	)
	
	(method (init)
		((= cycler (EndLoop new:)) init: self)
	)
)

(instance Fly of Actor
	(properties
		y 123
		x 274
		view 130
	)
)

(instance Fly2 of Actor
	(properties
		y 179
		x 297
		view 130
	)
)

(instance Fly3 of Actor
	(properties
		y 139
		x 217
		view 130
	)
)

(instance Fly4 of Actor
	(properties
		y 179
		x 257
		view 130
	)
)

(instance Fly5 of Actor
	(properties
		y 139
		x 197
		view 130
	)
)

(instance flyCage of Cage)

(instance House of RFeature
	(properties
		nsTop 34
		nsBottom 79
		nsRight 34
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/gazebo'))
			(event claimed: TRUE)
			(Print 30 2)
		)
	)
)
