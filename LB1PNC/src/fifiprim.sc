;;; Sierra Script 1.0 - (do not remove this comment)
(script# 244)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	fifiprim 0
)
(synonyms
	(fifi girl)
)

(local
	[local0 2]
	talkCount
	local3
)
(instance Fifi of Prop
	(properties
		y 129
		x 242
		view 468
		priority 13
		signal fixPriOn
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
						(DoVerb {tell fifi about necklace})						
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
							(cond
								 ((not (& global207 $0010))
									(event claimed: TRUE)
									(DoLook {fifi})
								)
								(
									(and
										(& global207 $0010)
										(or (MousedOn self event shiftDown) (Said 'examine/fifi'))
									)
									(event claimed: TRUE)
									(Print 244 5)
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
		
		(if (> (ego x?) 64)
			(cond 
				((Said 'hear/fifi')
					(Print 244 0)
				)
				((Said 'converse/fifi')
					(= theTalker talkFIFI)
					(switch talkCount
						(0 (Say 1 244 1))
						(1 (Say 1 244 2))
						(2 (Say 1 244 3))
						(else  (Say 1 244 4))
					)
					(++ talkCount)
				)
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
					(Print 244 5)
				)
			)
		)
	)
)

(instance fifiprim of Region
	
	(method (init)
		(super init:)
		(Bset 20)
		(LoadMany 143 243 250)
		(Load VIEW 904)
		(= global208 16)
		(= [global377 4] 250)
		(LoadMany SOUND 224 229)
		(Fifi init: stopUpd:)
		(FifiButt init: stopUpd:)
	)
	
	(method (doit)
		(if (and (> (ego x?) 64) (not script))
			(self setScript: primp)
			(gDoor init: setScript: playRecord)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance primp of Script
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fifi view: 468 loop: 0 cycleSpeed: 1 setCycle: EndLoop self)
			)
			(1
				(Fifi loop: 1 setCycle: Forward)
				(= seconds 3)
			)
			(2
				(Fifi loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(3
				(Fifi loop: 3 setCycle: Forward)
				(= seconds 3)
			)
			(4
				(Fifi loop: 0 cel: 1 setCycle: BegLoop self)
			)
			(5
				(= seconds 8)
			)
			(6
				(Fifi loop: 4 cel: 0 setCycle: EndLoop self)
			)
			(7
				(Fifi loop: 5 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(8
				(Fifi loop: 4 cel: 1 setCycle: BegLoop self)
			)
			(9
				(= seconds 8)
			)
			(10
				(Fifi loop: 6 cel: 0 setCycle: EndLoop self)
			)
			(11
				(Fifi loop: 7 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(12
				(Fifi loop: 6 cel: 1 setCycle: BegLoop self)
			)
			(13
				(if local3
					(switch (Random 1 3)
						(1 (= state -1))
						(2 (= state 5))
						(3 (= state 9))
					)
				)
				(= seconds 6)
			)
			(14
				(++ local3)
				(Fifi view: 477 loop: 0 cel: 0 setCycle: EndLoop self)
			)
			(15
				(Fifi loop: 1 setCycle: Forward)
				(= seconds 3)
			)
			(16
				(Fifi loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(17
				(Fifi loop: 3 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(18
				(Fifi loop: 2 cel: 3 setCycle: BegLoop self)
				(= state -1)
			)
		)
	)
)

(instance playRecord of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Forward)
				(mySound
					number: (if (== (mySound number?) 229) 224 else 229)
					loop: 1
					play: self
				)
				(= state -1)
			)
		)
	)
)

(instance mySound of Sound)

(instance FifiButt of Prop
	(properties
		y 153
		x 252
		view 477
		loop 4
	)
)
