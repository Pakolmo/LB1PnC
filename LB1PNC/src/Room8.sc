;;; Sierra Script 1.0 - (do not remove this comment)
(script# 8)
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
	Room8 0
)
(synonyms
	(bayou water)
)

(local
	local0
	local1
	dying
	local3
	temp7
)
(instance Room8 of Room
	(properties
		picture 8
	)
	
	(method (init)
		(= horizon 120)
		(= south 30)
		(= north 7)
		(super init:)
		(addToPics add: limb gator1 eachElementDo: #init doit:)
		(self setRegions: 205 setFeatures: gator1)
		(LoadMany VIEW 3 35 650)
		(Load SOUND 10 82)
		(if howFast
			(ripple1
				ignoreActors: TRUE
				cycleSpeed: 1
				setCycle: Forward
				init:
			)
			(ripple2
				ignoreActors: TRUE
				cycleSpeed: 1
				setCycle: Forward
				init:
			)
			(flyCage left: 160 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 6
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
				setLoop: 6
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
				setLoop: 6
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
				setLoop: 6
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
				setLoop: 6
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: TRUE
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
		)
		(= local1 0)
		(if (and (== currentAct 3) (< global115 4))
			(self setRegions: 203)
		)
		(switch prevRoomNum
			(18 (ego posn: 1 130))
			(24 (ego posn: 1 170))
			(30 (ego posn: (ego x?) 188))
			(else  (ego posn: 5 125))
		)
		(ego view: 0 init:)
		(Gator
			cycleSpeed: 1
			init:
			stopUpd:
			setScript: gatorScript
		)
		(HandsOn)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 8 0)
		)
		(cond 
			((< (ego y?) 141)
				(= local3 1)
			)
			((> (ego y?) 176)
				(= local3 2)
			)
			((and (< (ego y?) 167) (> (ego y?) 151))
				(= local3 3)
			)
			(else
				(= local3 0)
			)
		)
		(if
			(and
				(& (ego onControl: origin) cBLUE)
				(not dying)
				(not local0)
			)
			(= dying TRUE)
			(self setScript: sink)
		)
		(if (== (ego edgeHit?) WEST)
			(if (< (ego y?) 165)
				(curRoom newRoom: 18)
			else
				(curRoom newRoom: 24)
			)
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
		
		
		
						(if (ClickedOnObj Gator (event x?) (event y?)) ;alligator
					(event claimed: TRUE)
					(switch theCursor
					(602 ;necklace_
						(Print 8 9)						
					)
					(604 ;monocle
						(Print 8 9)						
					)
					
					(613 ;lantern_
						(Print 8 9)						
					)
					(611 ;oilcan_
						(Print 8 9)						
					)
					(626 ;rolling_pin_
						(Print 8 9)						
					)
					(620 ;skeleton_key_
						(Print 8 9)						
					)
					(627 ;poker_
						(Print 8 9)						
					)															
					(607 ;crowbar_
						(Print 8 9)						
					)
					(628 ;cigar_butt_
						(Print 8 9)						
					)
					(625 ;broken_record_
						(Print 8 9)						
					)
					(601 ;notebook___pencil_
						(Print 8 9)					
					)
					(603 ;_7_crackers________
						(Print 8 9)						
					)
					(605 ;soup_bone_
						(DoVerb {tell lil about soup bone})						
					)
					(606 ;valve_handle_
						(Print 8 9)						
					)
					(618 ;bullet_
						(Print 8 9)						
					)
					(617 ;derringer__
						(Print 8 9)						
					)
					(614 ;matches_
						(Print 8 9)						
					)
					(615 ;carrot_
						(Print 8 9)						
					)
					(619 ;brass_key_
						(Print 8 9)						
					)
					(616 ;diary_
						(Print 8 9)						
					)
					(621 ;crank_
						(Print 8 9)					
					)
					(612 ;cane_
						(Print 8 9)						
					)
					(622 ;pouch_
						(Print 8 9)						
					)																																																																																
					(630 ;handkerchief_
						(Print 8 9)
					)
					
					
						
						
						
						
						
						
						
						
						
						(996
								(DoVerb {feed alligator})
;;;									(if theInvItem
;;;										(if haveInvItem
;;;											(Print 8 9)
;;;										else
;;;											(DontHave)
;;;										)
;;;									else
;;;										(Print 8 9)
;;;									)
						)
						
						(998
							(DoVerb {examine alligator})
							(event claimed: TRUE)
							(Print 8 3)
						)
						(995
														(= temp7
												(Print
													{alligator}
													#button {get} 1
													#button {pat} 2								
													#button {kill} 3	

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
						(else
						
							(event claimed: FALSE)
						)
					)

						)
						
		
		

		
						(if (ClickedOnObj gator1 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(Print 8 3)
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
					(Said '[<around,at][/room]')
				)
				(Print 8 0)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance gatorScript of Script
	
	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (Gator cel?) 3))
			(myMusic number: 82 loop: 1 play:)
		)
		(if (> state 1)
			(cond 
				(local3
					(if local1
						(= cycles 1)
					)
				)
				((not local1)
					(= cycles 1)
				)
			)
			(if
				(and
					(< (ego distanceTo: Gator) 21)
					(== local1 0)
					(not local0)
					(& (ego onControl: origin) cBLUE)
				)
				(= local0 1)
				(self changeState: 6)
			)
		)
	)
	
	(method (changeState newState &tmp deathIconLastCel)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Gator cycleSpeed: 2 setCycle: EndLoop self)
			)
			(2 (= local1 1))
			(3
				(= local1 0)
				(Gator
					illegalBits: -32671
					posn:
						(switch local3
							(1 105)
							(2 259)
							(3 167)
						)
						(switch local3
							(1 133)
							(2 173)
							(3 159)
						)
					loop: 5
					cycleSpeed: 0
					setCycle: EndLoop self
				)
			)
			(4
				(Gator loop: 6 setCycle: Forward)
			)
			(5
				(= local1 (= state 1))
				(Gator loop: 5 cel: 3 setCycle: BegLoop self)
			)
			(6
				(HandsOff)
				(cSound stop:)
				(myMusic number: 10 loop: 1 play:)
				(if (== local3 1)
					(Gator setPri: 9)
				)
				(Gator
					view: 3
					loop: 0
					cel: 3
					illegalBits: 0
					posn: (- (ego x?) 3) (+ (ego y?) 4)
					setCycle: EndLoop self
					init:
				)
				(ego hide:)
			)
			(7 (= seconds 3))
			(8
				(myMusic stop:)
				(deathIcon view: 650 loop: 0)
				(= deathIconLastCel (deathIcon lastCel:))
				(= cIcon deathIcon)
				(= deathLoop 0)
				(= deathCel deathIconLastCel)
				(EgoDead 8 1)
			)
		)
	)
)

(instance sink of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and (== state 0) (> (ego cel?) 1)) (= local0 1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Room8 south: 0 north: 0)
				(HandsOff)
				(cSound stop:)
				(myMusic number: 82 loop: 1 play:)
				(ego
					view: 35
					cel: 0
					cycleSpeed: 3
					xStep: 3
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
					setCycle: EndLoop self
				)
			)
			(1 (ego hide:) (= seconds 3))
			(2
				(if (== (Gator loop?) 0)
					(myMusic stop:)
					(client setScript: 0)
				else
					(deathIcon view: 13 loop: 5 cel: 0)
					(= cIcon deathIcon)
					(= deathLoop 5)
					(= deathCel 0)
					(= cyclingIcon 1)
					(EgoDead 8 2)
				)
			)
		)
	)
)

(instance Gator of Actor
	(properties
		y 148
		x 275
		view 108
		loop 2
	)
	
	(method (handleEvent event)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/alligator'))
				(event claimed: TRUE)
				(Print 8 3)
			)
			((Said '/alligator>')
				(cond 
					((Said 'get,capture/alligator')
						(Print 8 4)
					)
					((Said 'pat/alligator')
						(Print 8 5)
					)
					((Said 'converse/alligator')
						(Print 8 6)
					)
					((Said 'kiss/alligator')
						(Print 8 7)
					)
					((Said 'kill/alligator')
						(Print 8 8)
					)
				)
			)
			(
				(or
					(Said 'feed,deliver/alligator')
					(Said 'feed,deliver/*/alligator')
					(Said 'feed,deliver/*<alligator')
				)
				(if theInvItem
					(if haveInvItem
						(Print 8 9)
					else
						(DontHave)
					)
				else
					(Print 8 9)
				)
			)
		)
	)
)

(instance ripple1 of Prop
	(properties
		y 110
		x 306
		view 108
	)
)

(instance ripple2 of Prop
	(properties
		y 140
		x 263
		view 108
		loop 1
	)
)

(instance myMusic of Sound
	(properties
		number 10
		loop 0
	)
)

(instance limb of RPicView
	(properties
		y 144
		x 148
		view 108
		loop 8
	)
)

(instance gator1 of RPicView
	(properties
		y 78
		x 265
		view 108
		loop 8
		cel 1
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 8 3)
		)
	)
)

(instance deathIcon of DCIcon
	
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
		x 287
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
