;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	coloroom 0
)
(synonyms
	(butt cigarette)
	(colonel person fellow)
)

(local
	local0
	talkCount
	temp7
)
(instance Colonel of Prop
	
	(method (handleEvent event)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0200)))
				(event claimed: TRUE)
				(DoLook {colonel})
			)
			(
				(and
					(& global207 $0200)
					(or (MousedOn self event shiftDown) (Said 'examine/colonel'))
				)
				(event claimed: TRUE)
				(Print 240 0)
			)
		)
	)
)

(instance smoke1 of Prop)

(instance smoke2 of Prop)

(instance coloroom of Region
	
	(method (init &tmp temp0 theX theY)
		(super init:)
		(= theX 175)
		(= theY 140)
		(switch currentAct
			(1
				(= temp0 253)
				(= theX 133)
				(= theY 98)
			)
			(2 (= temp0 285))
			(3
				(= temp0 292)
				(= theX 229)
				(= theY 95)
			)
			(5 (= temp0 374))
			(6 (= temp0 375))
			(else
				(= temp0 376)
			)
		)
		(Load FONT 4)
		(LoadMany 143 243 temp0)
		(Load VIEW 909)
		(= global208 512)
		(= [global377 9] temp0)
		(Colonel
			view: 304
			x: theX
			y: theY
			init:
			stopUpd:
			setScript: colonelActions
		)
		(smoke1
			view: 304
			loop: 2
			cel: 0
			posn: (+ (Colonel x?) 6) (- (Colonel y?) 30)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(smoke2
			view: 304
			loop: 3
			cel: 0
			posn: (+ (Colonel x?) 11) (- (Colonel y?) 24)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(Glow
			posn: (+ (Colonel x?) 10) (Colonel y?)
			z: 29
			init:
			hide:
		)
	)
	
	(method (doit)
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
						(if (ClickedOnObj Colonel (event x?) (event y?)) 

					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Colonel about handkerchief})						
					)
					(604 ;monocle
						(DoVerb {tell Colonel about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Colonel about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Colonel about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Colonel about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Colonel about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Colonel about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Colonel about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Colonel about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Colonel about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Colonel about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Colonel about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Colonel about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Colonel about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Colonel about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Colonel about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Colonel about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Colonel about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Colonel about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Colonel about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Colonel about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Colonel about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Colonel about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Colonel about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Jules})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about blaze})
							)															
						(996 ;talk
							(DoVerb {converse Colonel})
						)
						(998	
							(DoVerb {Examine Colonel})
						)
						(995
							(= temp7
												(Print
													{Colonel}
													#button {Mover} 1
													#button {Mirar Cigarro} 2								
													#button {Coger Cigarro} 3
													#button {Oler Cigarro} 3
												)
											)
											(switch temp7
												(1 
													(DoVerb {move wheelchair})
												)
												(2 
													(DoVerb {examine butt})
												)		
												(3 
													(DoVerb {get butt})
												)		
												(4 
													(DoVerb {smell butt})
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
					((Said 'get,move,press/wheelchair')
						(Print 240 1)
					)
					((Said 'examine/butt')
						(Bset fExaminedCigar)
						(Print 240 2)
					)
					((Said 'hear/colonel')
						(Print 240 3)
					)
					((Said 'get/butt') (Print 240 4))
					((and (Said 'converse>') (Said '/colonel'))
						(= theTalker talkCOLONEL)
						(switch currentAct
							(7
								(switch talkCount
									(0 (Say 1 240 5))
									(1 (Say 1 240 6))
									(else  (Print 240 7))
								)
							)
							(else 
								(switch talkCount
									(0 (Say 1 240 8))
									(1 (Say 1 240 9))
									(2 (Say 1 240 10))
									(else  (Print 240 11))
								)
							)
						)
						(++ talkCount)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance colonelActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel loop: 0 cel: 0 setCycle: EndLoop self)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Forward)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: BegLoop self
				)
			)
			(3
				(smoke2 setCycle: Forward show:)
				(smoke1 show: setCycle: EndLoop self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)
