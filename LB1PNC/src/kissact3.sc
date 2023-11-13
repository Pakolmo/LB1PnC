;;; Sierra Script 1.0 - (do not remove this comment)
(script# 383)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	kissact3 0
)
(synonyms
	(fifi girl)
	(butler fellow)
)

(local
	jeevesToXY = [107 139 163 139 230 139 98 155 175 155 258 155]
	fifiToXY = [163 94 222 112 177 92 90 94]
	randJeeves
	randFifi
	jeevesTalkCount
	fifiTalkCount
	temp7
)
(instance myMusic of Sound)

(instance kissact3 of Region
	
	(method (init)
		(super init:)
		(Bset fSawFifiJeevesTogether)
		(LoadMany VIEW 467 470 447 459)
		(Load FONT 4)
		(Load SCRIPT AVOIDER)
		(Load SOUND 51)
		(= global192 1)
		(LoadMany 143 243 294 377)
		(LoadMany VIEW 470 904 910)
		(= global208
;;;			(| (|= global208 $0010) $0400)
			(| (= global208 (| global208 $0010)) $0400)
		)
		(= [global377 4] 294)
		(= [global377 10] 377)
		(myMusic number: 112 loop: 0)
		(Duster illegalBits: 0 ignoreActors: TRUE init:)
		(Fifi setAvoider: (Avoider new:) init:)
		(self setScript: kiss)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed?) (return))
	)
)

(instance kiss of Script
	
	(method (doit)
		(if (and (== state 5) (== (Fifi cel?) 4))
			(Duster dispose:)
		)
		(if (and (== state 5) (== (Fifi cel?) 1))
			(Jeeves loop: 8 cel: 0 setCycle: EndLoop)
		)
		(if
			(and
				(== state 5)
				(== (Jeeves cel?) 1)
				(== (Jeeves loop?) 8)
			)
			(Jeeves loop: 9 setCycle: Forward)
		)
		(if (and (== state 1) (== (Fifi cel?) 1))
			(Duster
				setStep: 3 3
				setLoop: 1
				setCycle: Forward
				setMotion: MoveTo 136 142
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Fifi
					view: 475
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: EndLoop self
				)
			)
			(2
				(myMusic number: 51 loop: 1 play:)
				(Duster setCycle: 0 loop: 2 cel: 0)
				(Fifi loop: 3 cel: 0 setCycle: EndLoop self)
			)
			(3
				(Fifi loop: 4 cel: 0 setCycle: EndLoop self)
			)
			(4
				(Fifi cel: 0 loop: 5 setCycle: Forward)
				(Jeeves setCycle: EndLoop setAvoider: (Avoider new:) init:)
				(= seconds 3)
			)
			(5
				(Fifi loop: 7 setCycle: EndLoop self)
			)
			(6
				(HandsOn)
				(Fifi cycleSpeed: 0 setScript: fifiActions)
				(Jeeves cycleSpeed: 0 setScript: jeevesActions)
				(client setScript: 0)
			)
		)
	)
)

(instance jeevesActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= randJeeves (Random 0 5))
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: FALSE
					setMotion:
						MoveTo
						[jeevesToXY (* randJeeves 2)]
						[jeevesToXY (+ (* randJeeves 2) 1)]
						self
				)
			)
			(1
				(Jeeves
					view: 459
					cel: 0
					loop: (if (< (Random 1 100) 50) 0 else 1)
					setCycle: EndLoop self
				)
			)
			(2
				(Jeeves
					loop: (if (== (Jeeves loop?) 0) 2 else 3)
					setCycle: Forward
				)
				(= seconds 4)
			)
			(3
				(Jeeves
					cel: 2
					loop: (if (== (Jeeves loop?) 2) 0 else 1)
					setCycle: BegLoop self
				)
				(= state -1)
			)
		)
	)
)

(instance fifiActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion: MoveTo 64 139 self
				)
			)
			(1
				(Fifi setMotion: MoveTo 56 103 self)
			)
			(2
				(= randFifi (Random 0 3))
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion:
						MoveTo
						[fifiToXY (* randFifi 2)]
						[fifiToXY (+ (* randFifi 2) 1)]
						self
				)
			)
			(3
				(Fifi
					view: 470
					cel: 0
					loop:
					(switch randFifi
						(0 1)
						(1 0)
						(2 1)
						(else  0)
					)
					setCycle: EndLoop self
				)
			)
			(4
				(Fifi
					loop:
					(switch randFifi
						(0 3)
						(1 2)
						(2 3)
						(else  2)
					)
					setCycle: Forward
				)
				(= seconds 4)
			)
			(5
				(Fifi cel: 2 setCycle: BegLoop self)
				(= state 1)
			)
		)
	)
)

(instance Jeeves of Actor
	(properties
		y 153
		x 169
		view 475
		loop 6
	)
	
	(method (handleEvent event)

		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				
				(if (ClickedOnObj Jeeves (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell jeeves about handkerchief})						
					)
					(604 ;monocle
						(DoVerb {tell jeeves about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell jeeves about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell jeeves about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell jeeves about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell jeeves about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell jeeves about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell jeeves about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell jeeves about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell jeeves about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell jeeves about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell jeeves about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell jeeves about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell jeeves about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell jeeves about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell jeeves about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell jeeves about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell jeeves about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell jeeves about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell jeeves about diary})						
					)
					(621 ;crank_
						(DoVerb {tell jeeves about crank})						
					)
					(612 ;cane_
						(DoVerb {tell jeeves about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell jeeves about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell jeeves about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear gertie})
							)						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask jeeves about Jules})
							)						
						(998		
							(DoVerb {examine butler})
						)
						(996
							(DoVerb {converse jeeves})	
						)	
						(else
						
							(event claimed: FALSE)
						)
					)

				)
			)
						)		
		
		
	



		(cond 
			(
				(and
					(not (& global207 $0400))
					(or (MousedOn self event shiftDown) (Said 'examine/butler'))
				)
				(= theTalker talkJEEVES)
				(|= global207 $0400)
				(event claimed: TRUE)
				(Say 0 383 0)
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event shiftDown) (Said 'examine/butler'))
				)
				(event claimed: TRUE)
				(Print 383 1)
			)
			((Said 'converse,examine/person')
				(Print 383 2)
			)
			((Said 'converse/people')
				(Print 383 3)
			)
			((Said 'examine/people')
				(Print 383 4)
			)
			((Said '/butler>')
				(cond 
					((Said 'converse')
						(= theTalker talkJEEVES)
						(switch jeevesTalkCount
							(0 (Say 1 383 5))
							(1 (Say 1 383 6))
							(2 (Say 1 383 7))
							(else  (Print 383 8))
						)
						(++ jeevesTalkCount)
					)
					((Said 'hear')
						(Print 383 9)
					)
				)
			)
		)
	)
)

(instance Fifi of Actor
	(properties
		y 153
		x 148
		view 475
	)
	
	(method (handleEvent event)
		
			
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					(if (ClickedOnObj Fifi (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell fifi about handkerchief})						
					)
					(604 ;monocle
						(DoVerb {tell fifi about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell fifi about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell fifi about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell fifi about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell fifi about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell fifi about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell fifi about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell fifi about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell fifi about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell fifi about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell fifi about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell fifi about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell fifi about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell fifi about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell fifi about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell fifi about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell fifi about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell fifi about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell fifi about diary})						
					)
					(621 ;crank_
						(DoVerb {tell fifi about crank})						
					)
					(612 ;cane_
						(DoVerb {tell fifi about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell fifi about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell fifi about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about Jules})
							)
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask fifi about blaze})
							)							
													
							
							
						(994	
							(DoVerb {hear Fifi})
						)							
						(996 ;talk
							(DoVerb {converse Fifi})
						)
						(998	
							(DoVerb {Examine Fifi})
						)
						(995
							(= temp7
												(Print
													{Fifi}
													#button {Coger} 1
													#button {Matar} 2								
													#button {Besar} 3
													#button {Abrazar} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get fifi})
												)
												(2 
													(DoVerb {kill fifi})
												)		
												(3 
													(DoVerb {kiss fifi})
												)		
												(4 
													(DoVerb {embrace fifi})
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
		
		
		
		
		
		
		
		
		
		
		
		
		(if (< (ego distanceTo: Fifi) (ego distanceTo: Jeeves))
			(= global214 16)
		else
			(= global214 1024)
		)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0010)))
				(event claimed: TRUE)
				(DoLook {fifi})
			)
			(
				(and
					(& global207 $0010)
					(or (MousedOn self event shiftDown) (Said 'examine/fifi'))
				)
				(event claimed: TRUE)
				(Print 383 10)
			)
			(
			(and (== (event type?) saidEvent) (Said '*/fifi>'))
				(cond 
					((Said 'converse')
						(= theTalker talkFIFI)
						(switch fifiTalkCount
							(0 (Say 1 383 11))
							(1 (Say 1 383 12))
							(2 (Say 1 383 13))
							(3 (Say 1 383 14))
							(else  (Say 1 383 15))
						)
						(++ fifiTalkCount)
					)
					((Said 'hear')
						(Print 383 16)
					)
				)
			)
		)
	)
)

(instance Duster of Actor
	(properties
		y 124
		x 158
		view 475
		loop 1
	)
)

;;;(instance Sweeper of Prop
;;;	(properties
;;;		y 119
;;;		x 158
;;;		view 475
;;;		loop 2
;;;		cel 2
;;;	)
;;;)
