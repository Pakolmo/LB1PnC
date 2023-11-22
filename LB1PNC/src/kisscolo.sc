;;; Sierra Script 1.0 - (do not remove this comment)
(script# 231) ;OK
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
	kisscolo 0
)
(synonyms
	(colonel fellow)
	(fifi girl)
	(butt cigarette)
)

(local
	local0
	talkCount
	fifiDir
	temp7
)
(instance kisscolo of Region
	
	(method (init)
		(super init:)
		(LoadMany FONT 4 41)
		(Load SCRIPT AVOIDER)
		(LoadMany VIEW 470 642 909)
		(LoadMany SOUND 29 51 94 95 96)
		(LoadMany 143 243 225 406)
		(= global208 512)
		(= [global377 9] 225)
		(if (and (== currentAct 0) (== [global368 3] 0))
			(= [global368 3] 1800)
			(LoadMany VIEW 304 464 904)
			(= global195 16)
			(Fifi view: 466 setAvoider: (Avoider new:) init: hide:)
			(Colonel view: 466 init: stopUpd:)
			(self setScript: kiss)
		else
			(if (and (!= [global368 3] 1) (== global124 0))
				(= global195 16)
				(Fifi
					view: 464
					setAvoider: (Avoider new:)
					init:
;;;					illegalBits: (| cWHITE cGREEN)
					illegalBits: -32764
					setScript: fifiActions
				)
			)
			(Colonel
				view: 304
				init:
				stopUpd:
				setScript: colonelActions
			)
		)
		(Glow
			posn: (+ (Colonel x?) 10) (Colonel y?)
			z: 29
			init:
			hide:
		)
		(smoke1
			posn: (+ (Colonel x?) 6) (- (Colonel y?) 30)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(smoke2
			posn: (+ (Colonel x?) 11) (- (Colonel y?) 24)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
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
		(super handleEvent: event)
		
		
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
								(DoVerb {ask fifi about gertrude})
							)
							(2
								(DoVerb {tell fifi about gertrude})
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
								(DoVerb {ask fifi about Celie})
							)
							(2
								(DoVerb {tell fifi about Celie})
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
								(DoVerb {ask fifi about gloria})
							)
							(2
								(DoVerb {tell fifi about gloria})
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
								(DoVerb {ask fifi about ethel})
							)
							(2
								(DoVerb {tell fifi about ethel})
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
								(DoVerb {ask fifi about fifi})
							)
							(2
								(DoVerb {tell fifi about fifi})
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
								(DoVerb {ask fifi about lillian})
							)
							(2
								(DoVerb {tell fifi about lillian})
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
								(DoVerb {ask fifi about Clarence})
							)
							(2
								(DoVerb {tell fifi about clarence})
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
								(DoVerb {ask fifi about Wilbur})
							)
							(2
								(DoVerb {tell fifi about Wilbur})
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
								(DoVerb {ask fifi about rudolph})
							)
							(2
								(DoVerb {tell fifi about rudolph})
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
								(DoVerb {ask fifi about colonel})
							)
							(2
								(DoVerb {tell fifi about colonel})
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
								(DoVerb {ask fifi about Jeeves})
							)
							(2
								(DoVerb {tell fifi about Jeeves})
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
								(DoVerb {ask fifi about beauregard})
							)
							(2
								(DoVerb {tell fifi about beauregard})
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
								(DoVerb {ask fifi about polly})
							)
							(2
								(DoVerb {tell fifi about polly})
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
								(DoVerb {ask fifi about blaze})
							)
							(2
								(DoVerb {tell fifi about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
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
		
					(if (ClickedOnObj Colonel (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Colonel about necklace})						
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
								(DoVerb {ask colonel about gertrude})
							)
							(2
								(DoVerb {tell colonel about gertrude})
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
								(DoVerb {ask colonel about Celie})
							)
							(2
								(DoVerb {tell colonel about Celie})
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
								(DoVerb {ask colonel about gloria})
							)
							(2
								(DoVerb {tell colonel about gloria})
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
								(DoVerb {ask colonel about ethel})
							)
							(2
								(DoVerb {tell colonel about ethel})
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
								(DoVerb {ask colonel about fifi})
							)
							(2
								(DoVerb {tell colonel about fifi})
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
								(DoVerb {ask colonel about lillian})
							)
							(2
								(DoVerb {tell colonel about lillian})
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
								(DoVerb {ask colonel about Clarence})
							)
							(2
								(DoVerb {tell colonel about clarence})
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
								(DoVerb {ask colonel about Wilbur})
							)
							(2
								(DoVerb {tell colonel about Wilbur})
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
								(DoVerb {ask colonel about rudolph})
							)
							(2
								(DoVerb {tell colonel about rudolph})
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
								(DoVerb {ask colonel about colonel})
							)
							(2
								(DoVerb {tell colonel about colonel})
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
								(DoVerb {ask colonel about Jeeves})
							)
							(2
								(DoVerb {tell colonel about Jeeves})
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
								(DoVerb {ask colonel about beauregard})
							)
							(2
								(DoVerb {tell colonel about beauregard})
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
								(DoVerb {ask colonel about polly})
							)
							(2
								(DoVerb {tell colonel about polly})
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
								(DoVerb {ask colonel about blaze})
							)
							(2
								(DoVerb {tell colonel about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
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
					((Said 'examine/butt')
						(Bset fExaminedCigar)
						(Print 231 0)
					)
					((Said 'hear/fifi,colonel')
						(Print 231 1)
					)
					((Said 'get/butt')
						(Print 231 2)
					)
					((and (Said 'converse>') (Said '/colonel,person'))
						(= theTalker talkCOLONEL)
						(switch talkCount
							(0 (Say 1 231 3))
							(1 (Say 1 231 4))
							(2 (Say 1 231 5))
							(3 (Say 1 231 6))
							(4 (Print 231 7))
						)
						(if (< talkCount 4)
							(++ talkCount)
						)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance kiss of Script

	(method (doit)
		(if (and (== state 1) (== (Colonel cel?) 2))
			(Kiss number: 51 loop: 1 play:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0008))
;;;						(|= global118 $0008)
						(= global118 (| global118 $0008))						
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
					((self script?)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(Colonel cycleSpeed: 2 setCycle: EndLoop self)
			)
			(2
				(Print 231 8
					#at 140 150
					#font 4
					#width 125
					#mode teJustCenter
					#dispose
				)
				(Colonel
					view: 304
					posn: 185 140
					loop: 0
					cel: 0
					cycleSpeed: 0
				)
				(Fifi
					show:
					view: 466
					loop: 1
					cycleSpeed: 2
					ignoreActors: TRUE
					setCycle: Forward
				)
				(= seconds 4)
			)
			(3
				(Fifi cel: 0 loop: 2 setCycle: EndLoop self)
			)
			(4
				(HandsOn)
				(cls)
				(Colonel setScript: colonelActions)
				(Fifi
					view: 470
					loop: 1
					cycleSpeed: 0
;;;					illegalBits: (| cWHITE cGREEN)
					illegalBits: -32764
					setScript: fifiActions
				)
				(client setScript: 0)
			)
		)
	)
)

(instance fifiActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= fifiDir (Random 0 4))
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: FALSE
					setMotion:
						MoveTo
						(switch fifiDir
							(0 225)
							(1 244)
							(2 218)
							(3 130)
							(4 66)
						)
						(switch fifiDir
							(0 126)
							(1 129)
							(2 90)
							(3 94)
							(4 137)
						)
						self
				)
			)
			(1
				(Fifi
					view: 470
					cel: 0
					loop:
					(switch fifiDir
						(0 5)
						(1 0)
						(2 1)
						(3 1)
						(4 5)
					)
					setCycle: EndLoop self
				)
			)
			(2
				(Fifi
					loop:
					(switch fifiDir
						(0 7)
						(1 2)
						(2 3)
						(3 3)
						(4 7)
					)
					setCycle: Forward
				)
				(= seconds 4)
			)
			(3
				(Fifi cel: 2 setCycle: BegLoop self)
				(= state -1)
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

(instance Colonel of Prop
	(properties
		y 140
		x 185
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get,move,press/wheelchair')
				(Print 231 9)
			)
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
				(Print 231 10)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		view 304
		loop 2
	)
)

(instance smoke2 of Prop
	(properties
		view 304
		loop 3
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)

(instance Fifi of Actor
	(properties
		y 140
		x 206
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'converse,examine/person')
				(Print 231 11)
			)
			((Said 'converse/people')
				(Print 231 12)
			)
			((Said 'examine/people')
				(Print 231 13)
			)
			(
				(or
					(Said 'ask,tell/fifi/*<about')
					(Said 'converse/fifi')
					(Said 'deliver,hold/*<fifi')
					(Said 'deliver,hold/*/fifi')
				)
				(event claimed: FALSE)
				(if (Said 'deliver,hold')
					(if (and theInvItem haveInvItem)
						(Print 231 14)
					else
						(DontHave)
					)
				else
					(Print 231 14)
					(event claimed: TRUE)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/fifi'))
				(if (& global207 $0010)
					(Print 231 15)
				else
;;;					(|= global207 $0010)
					(= global207 (| global207 $0010))
					(= theTalker talkFIFI)
					(Say 0 231 16)
				)
				(event claimed: TRUE)
			)
			((Said '/fifi>')
				(cond 
					((Said 'get')
						(Print 231 17)
					)
					((Said 'kill')
						(Print 231 18)
					)
					((Said 'kiss')
						(Print 231 19)
					)
					((Said 'embrace')
						(Print 231 20)
					)
				)
			)
		)
	)
)

(instance Kiss of Sound)
