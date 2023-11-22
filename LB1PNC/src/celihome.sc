;;; Sierra Script 1.0 - (do not remove this comment)
(script# 262)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	celihome 0
)
(synonyms
	(celie person girl)
)

(local
	talkCount
	local1
	temp7
)
(instance Celie of Actor
	(properties
		view 480
	)
)

(instance CHead of Prop
	(properties
		y 102
		x 227
		view 489
		loop 1
		priority 10
		signal fixPriOn
	)
)

(instance celihome of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(Load VIEW 489)
		(Load FONT 4)
		(LoadMany VIEW 480 901)
		(= theTalker talkCELIE)
		(if enteredCelieHouse
			(Celie
				view: 480
				illegalBits: 0
				loop: 4
				cel: 0
				posn: 123 147
				init:
				setScript: cook
			)
		else
			(Celie posn: 123 147 init: setScript: sitDown)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)

		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
	
	

		
						(if (and (ClickedOnObj Celie (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell celie about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell celie about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell celie about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell celie about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell celie about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell celie about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell celie about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell celie about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell celie about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell celie about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell celie about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell celie about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {ask celie for soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell celie about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell celie about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell celie about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell celie about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell celie about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell celie about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell celie about diary})						
					)
					(621 ;crank_
						(DoVerb {tell celie about crank})						
					)
					(612 ;cane_
						(DoVerb {tell celie about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell celie about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell celie about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear celie})
							)						
						

						
					
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
												(= temp7
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about gertrude})
							)
							(2
								(DoVerb {tell celie about gertrude})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(931 ;Celie
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about Celie})
							)
							(2
								(DoVerb {tell celie about Celie})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about gloria})
							)
							(2
								(DoVerb {tell celie about gloria})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(933 ;Ethel
								
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about ethel})
							)
							(2
								(DoVerb {tell celie about ethel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(= temp7
														(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about fifi})
							)
							(2
								(DoVerb {tell celie about fifi})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about lillian})
							)
							(2
								(DoVerb {tell celie about lillian})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																				
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about Clarence})
							)
							(2
								(DoVerb {tell celie about clarence})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(937 ;Feels
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about Wilbur})
							)
							(2
								(DoVerb {tell celie about Wilbur})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about rudolph})
							)
							(2
								(DoVerb {tell celie about rudolph})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about colonel})
							)
							(2
								(DoVerb {tell celie about colonel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about Jeeves})
							)
							(2
								(DoVerb {tell celie about Jeeves})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
		
							(941 ;Dog
								(event type: 1 claimed: 1)
							(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about beauregard})
							)
							(2
								(DoVerb {tell celie about beauregard})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about polly})
							)
							(2
								(DoVerb {tell celie about polly})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)				
							(943 ;Horse
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask celie about blaze})
							)
							(2
								(DoVerb {tell celie about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
								
							

						(998		
							(DoLook {celie})
						)
						(996
							(DoVerb {Talk celie})	
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
					((Said 'examine/celie')
						(= theTalker talkCELIE)
						(if (& global207 $0002)
							(if enteredCelieHouse
								(Print 262 0) 
							else
								(Print 262 1)
							)
						else
							(Say 0 262 2)
						)
					)
					((Said 'converse>')
						(if (Said '/celie')
							(= theTalker talkCELIE)
							(if enteredCelieHouse
								(switch talkCount
									(0 (Say 1 262 3))
									(1 (Say 1 262 4))
									(2 (Say 1 262 5))
									(3 (Say 1 262 6))
									(4 (Say 1 262 7))
									(else  (Say 1 262 8))
								)
								(++ talkCount)
							else
								(switch talkCount
									(0 (Say 1 262 9))
									(1
										(Say 1 262 10)
										(Say 1 262 11)
										(Say 1 262 12)
										(Say 1 262 13)
										(Say 1 262 14)
										(Say 1 262 15)
									)
									(2 (Say 1 262 16))
									(3 (Say 1 262 17))
									(4 (Say 1 262 18))
									(5 (Say 1 262 19))
									(6 (Say 1 262 20))
									(else  (Print 262 21))
								)
								(++ talkCount)
							)
						)
					)
					((Said 'hear/celie')
						(Print 262 22)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance cook of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie
					setCycle: Walk
					illegalBits: 0
					setAvoider: (Avoider new:)
					setMotion: MoveTo 192 127 self
				)
			)
			(1
				(Celie
					view: 482
					loop: 4
					setAvoider: 0
					cycleSpeed: 1
					setCycle: EndLoop self
				)
			)
			(2
				(gDoor hide:)
				(Celie loop: 5 cycleSpeed: 1 setCycle: Forward)
				(= seconds (Random 3 8))
			)
			(3
				(gDoor show:)
				(Celie loop: 4 cel: 3 setCycle: BegLoop)
				(= state 0)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance sitDown of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie
					setCycle: Walk
					illegalBits: 0
					setAvoider: (Avoider new:)
					setMotion: MoveTo 213 138 self
				)
			)
			(1
				(Celie view: 489 setAvoider: 0 cel: 0 setCycle: EndLoop self)
				(DisposeScript 985)
			)
			(2
				(= theTalker talkCELIE)
				(Say 1 262 23)
				(Celie loop: 2)
				(CHead init:)
				(cls)
				(= seconds (Random 6 12))
			)
			(3
				(CHead setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(4
				(CHead setCycle: BegLoop)
				(= state 2)
				(= seconds (Random 6 12))
			)
		)
	)
)
