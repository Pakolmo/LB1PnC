;;; Sierra Script 1.0 - (do not remove this comment)
(script# 232)
(include game.sh)
(use Main)
(use atsgl)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	grargue 0
)
(synonyms
	(rudolph fellow)
	(actress girl)
)

(local
	gloriaTalkCount
	rudyTalkCount
	local2
	argueCount
	local4
	temp7
)
(procedure (GloriaPrint)
	(Gloria setCel: -1 loop: 1 setCycle: Forward)
	(Print &rest
		#at 40 140
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(procedure (RudyPrint)
	(rHead setCel: -1 setCycle: Forward)
	(Rudy setCycle: Forward)
	(Print &rest
		#at 171 140
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance grargue of Region
	
	(method (init)
		(super init:)
		(if (not (& global118 $0001))
			(LoadMany FONT 4 41)
			(Load VIEW 642)
			(LoadMany SOUND 29 94 95 96)
			(Load SCRIPT 406)
		)
		(LoadMany 143 243 223 222)
		(LoadMany 142 3 9)
		(= global208 260)
		(= [global377 2] 223)
		(= [global377 8] 222)
		(Gloria init:)
		(Rudy init:)
		(rHead setPri: 9 init:)
		(Smoke init: hide:)
		(Ash init: hide:)
		(if (!= prevRoomNum 49)
			(self setScript: argue)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(if (and (not (& global173 $0001)) (== [global368 0] 0))
			(= [global368 0] 1800)
		)
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
				(if (ClickedOnObj Gloria (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Gloria about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Gloria about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Gloria about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Gloria about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Gloria about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Gloria about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Gloria about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Gloria about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Gloria about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Gloria about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Gloria about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Gloria about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Gloria about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Gloria about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Gloria about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Gloria about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Gloria about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Gloria about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Gloria about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Gloria about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Gloria about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Gloria about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Gloria about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Gloria about handkerchief})
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
								(DoVerb {ask gloria about gertie})
							)
							(2
								(DoVerb {tell gloria about gertie})
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
								(DoVerb {ask gloria about Celie})
							)
							(2
								(DoVerb {tell gloria about Celie})
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
								(DoVerb {ask gloria about gloria})
							)
							(2
								(DoVerb {tell gloria about gloria})
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
								(DoVerb {ask gloria about ethel})
							)
							(2
								(DoVerb {tell gloria about ethel})
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
								(DoVerb {ask gloria about fifi})
							)
							(2
								(DoVerb {tell gloria about fifi})
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
								(DoVerb {ask gloria about lillian})
							)
							(2
								(DoVerb {tell gloria about lillian})
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
								(DoVerb {ask gloria about Clarence})
							)
							(2
								(DoVerb {tell gloria about clarence})
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
								(DoVerb {ask gloria about Wilbur})
							)
							(2
								(DoVerb {tell gloria about Wilbur})
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
								(DoVerb {ask gloria about rudolph})
							)
							(2
								(DoVerb {tell gloria about rudolph})
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
								(DoVerb {ask gloria about colonel})
							)
							(2
								(DoVerb {tell gloria about colonel})
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
								(DoVerb {ask gloria about Jeeves})
							)
							(2
								(DoVerb {tell gloria about Jeeves})
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
								(DoVerb {ask gloria about beauregard})
							)
							(2
								(DoVerb {tell gloria about beauregard})
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
								(DoVerb {ask gloria about polly})
							)
							(2
								(DoVerb {tell gloria about polly})
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
								(DoVerb {ask gloria about blaze})
							)
							(2
								(DoVerb {tell gloria about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
																								
						(996 ;talk
							(DoVerb {converse Gloria})
						)
						(994
								(DoVerb {hear Gloria})
						)
						(998	
							
							(= temp7
								(PrintSpecial
;;;									{Gloria}
;;;									#button {Examine} 1
;;;									#button {Examine cigar} 2
;;;									#button {Examine boa} 3
		
									{Gloria}
									#button {Mirar} 1
									#button {Mirar cigarro} 2								
									#button {Mirar boa} 3	
								)
							)
							(switch temp7
								(1 	

															(DoVerb {examine actress})
	
								)
								(2
									(DoVerb {examine cigarette}) 
								)
								(3
									(DoVerb {examine boa}) 
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
							
							
							
							
							
			(if (or (ClickedOnObj Rudy (event x?) (event y?)) 	
					 (ClickedOnObj rHead (event x?) (event y?)) 	)
					(event claimed: TRUE)
					(switch theCursor						
						
		
		
		
						
					(602 ;necklace_
						(DoVerb {tell rudolph about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell rudolph about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell rudolph about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell rudolph about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell rudolph about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell rudolph about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell rudolph about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell rudolph about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell rudolph about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell rudolph about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell rudolph about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell rudolph about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell rudolph about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell rudolph about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell rudolph about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell rudolph about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell rudolph about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell rudolph about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell rudolph about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell rudolph about diary})						
					)
					(621 ;crank_
						(DoVerb {tell rudolph about crank})						
					)
					(612 ;cane_
						(DoVerb {tell rudolph about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell rudolph about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell rudolph about handkerchief})
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
								(DoVerb {ask rudolph about gertie})
							)
							(2
								(DoVerb {tell rudolph about gertie})
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
								(DoVerb {ask rudolph about Celie})
							)
							(2
								(DoVerb {tell rudolph about Celie})
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
								(DoVerb {ask rudolph about gloria})
							)
							(2
								(DoVerb {tell rudolph about gloria})
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
								(DoVerb {ask rudolph about ethel})
							)
							(2
								(DoVerb {tell rudolph about ethel})
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
								(DoVerb {ask rudolph about fifi})
							)
							(2
								(DoVerb {tell rudolph about fifi})
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
								(DoVerb {ask rudolph about lillian})
							)
							(2
								(DoVerb {tell rudolph about lillian})
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
								(DoVerb {ask rudolph about Clarence})
							)
							(2
								(DoVerb {tell rudolph about clarence})
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
								(DoVerb {ask rudolph about Wilbur})
							)
							(2
								(DoVerb {tell rudolph about Wilbur})
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
								(DoVerb {ask rudolph about rudolph})
							)
							(2
								(DoVerb {tell rudolph about rudolph})
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
								(DoVerb {ask rudolph about colonel})
							)
							(2
								(DoVerb {tell rudolph about colonel})
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
								(DoVerb {ask rudolph about Jeeves})
							)
							(2
								(DoVerb {tell rudolph about Jeeves})
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
								(DoVerb {ask rudolph about beauregard})
							)
							(2
								(DoVerb {tell rudolph about beauregard})
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
								(DoVerb {ask rudolph about polly})
							)
							(2
								(DoVerb {tell rudolph about polly})
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
								(DoVerb {ask rudolph about blaze})
							)
							(2
								(DoVerb {tell rudolph about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																				
						(996 ;talk
							(DoVerb {converse rudolph})
						)
						(998

								(DoVerb {examine rudolph})

						)
						(994
								(DoVerb {hear rudolph})
						)						
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
		
		
		
			)
				)
		
		

		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '/cigarette')
							(Print 232 0)
						)
						((Said '/boa')
							(Print 232 1)
						)
					)
				)
				((Said 'hear/rudolph,actress')
					(Print 232 2)
				)
				((Said 'get,smoke>')
					(cond 
						((Said '/cigarette')
							(Print 232 3)
						)
						((Said '/boa')
							(Print 232 4)
						)
					)
				)
			)
		)
	)
)

(instance argue of Script

	(method (doit)
		(super doit:)
		(if (== global120 3)
			(User canInput: FALSE)
			(= global120 4)
			(= cycles 12)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0001))
;;;						(|= global118 $0001)
						(= global118 (| global118 $0001))
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
				(User canInput: FALSE)
				(if (== (= argueCount (& gCurRoomNum_2 $7fff)) gCurRoomNum_2)
					(if (< gCurRoomNum_2 6)
						(++ gCurRoomNum_2)
					else
						(= gCurRoomNum_2 -32765)
					)
				else
					(switch argueCount
						(3 (= gCurRoomNum_2 -32764))
						(4 (= gCurRoomNum_2 -32762))
						(6 (= gCurRoomNum_2 -32765))
					)
				)
				(switch argueCount
					(0 (GloriaPrint 232 5))
					(1 (GloriaPrint 232 6))
					(2 (RudyPrint 232 7))
					(3 (GloriaPrint 232 8))
					(4 (RudyPrint 232 9))
					(5 (RudyPrint 232 10))
					(6 (RudyPrint 232 11))
				)
				(= seconds 5)
			)
			(2
				(cls)
				(Gloria setCel: 0)
				(rHead loop: 4 setCel: 0)
				(Rudy loop: 0 setCycle: 0)
				(= seconds 1)
			)
			(3
				(cls)
				(switch argueCount
					(0
						(RudyPrint 232 12)
						(= seconds 3)
					)
					(5
						(RudyPrint 232 13)
						(= seconds 3)
					)
					(26
						(RudyPrint 232 14)
						(= seconds 3)
					)
					(else  (= cycles 1))
				)
			)
			(4
				(User canInput: TRUE)
				(Rudy setCycle: 0)
				(rHead setCel: 0 setScript: rudyActions)
				(cls)
				(Gloria setScript: gloriaActions)
			)
			(5
				(GloriaPrint 232 15)
				(= state 1)
				(= argueCount 26)
				(= seconds 5)
			)
		)
	)
)

(instance gloriaActions of Script
	
	(method (doit)
		(super doit:)
		(if (and (< global120 4) (> global120 0) (client script?))
			(++ global120)
			(client setScript: 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 6)))
			(1
				(Gloria cel: 0 loop: 0 cycleSpeed: 0 setCycle: EndLoop)
				(= seconds 3)
			)
			(2
				(Gloria
					cel: (- (NumCels Gloria) 1)
					loop: 0
					setCycle: BegLoop
				)
				(= seconds 2)
			)
			(3
				(Smoke
					show:
					setPri: (CoordPri (Gloria y?))
					setCycle: EndLoop self
				)
			)
			(4
				(Smoke cel: 0 hide:)
				(= seconds (Random 2 5))
			)
			(5
				(Gloria cel: 0 loop: 4 setCycle: EndLoop self)
			)
			(6
				(Gloria cel: 0 loop: 5 cycleSpeed: 1 setCycle: Forward)
				(Ash cel: 0 show: setCycle: EndLoop)
				(= cycles 5)
			)
			(7
				(Ash hide:)
				(Gloria cel: 2 loop: 4 setCycle: BegLoop self)
				(= state -1)
			)
		)
	)
)

(instance rudyActions of Script

	(method (doit)
		(super doit:)
		(if (and (< global120 4) (> global120 0) (client script?))
			(++ global120)
			(client setScript: 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(rHead setCel: -1 loop: 5 setCycle: EndLoop self)
				(= seconds (Random 3 5))
			)
			(2
				(Rudy cel: 0 loop: 2 setCycle: EndLoop)
				(= seconds (Random 3 5))
			)
			(3
				(rHead setCycle: BegLoop)
				(= seconds (Random 3 5))
			)
			(4
				(Rudy loop: 3 setCycle: EndLoop)
				(= seconds (Random 3 5))
			)
			(5
				(rHead setCycle: EndLoop)
				(= seconds (Random 5 8))
			)
			(6
				(rHead setCycle: BegLoop self)
				(= state 4)
			)
		)
	)
)

(instance Rudy of Prop
	(properties
		y 135
		x 178
		view 382
		cycleSpeed 2
	)
	
	(method (handleEvent event)
		(= theTalker talkRUDY)
		(if (< (ego distanceTo: Rudy) (ego distanceTo: Gloria))
			(= global214 256)
		else
			(= global214 4)
		)
		(cond 
			((Said 'converse/rudolph')
				(switch rudyTalkCount
					(0 (Say 1 232 16))
					(1 (Say 1 232 17))
					(else  (Print 232 18))
				)
				(++ rudyTalkCount)
			)
			((Said 'ask[/rudolph]/actress<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 13 232 19)
			)
			((and (not (& global207 $0100)) (MousedOn self event shiftDown))
				(event claimed: TRUE)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event shiftDown) (Said 'examine/rudolph'))
				)
				(event claimed: TRUE)
				(Print 232 20)
			)
		)
	)
)

(instance Gloria of Prop
	(properties
		y 137
		x 135
		view 362
	)
	
	(method (handleEvent event)
		(= theTalker talkGLORIA)
		(cond 
			((Said 'converse/actress')
				(switch gloriaTalkCount
					(0 (Say 1 232 21))
					(1 (Say 1 232 22))
					(else  (Print 232 23))
				)
				(++ gloriaTalkCount)
			)
			((Said 'ask[/actress]/rudolph<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 21 232 24)
			)
			((Said 'examine/people')
				(Print 232 20)
			)
			((Said 'examine,converse/person,men')
				(Print 232 25)
			)
			((Said 'converse/people')
				(Print 232 26)
			)
			((and (not (& global207 $0004)) (MousedOn self event shiftDown))
				(event claimed: TRUE)
				(DoLook {gloria})
			)
			(
				(and
					(& global207 $0004)
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/actress[/!*]')
					)
				)
				(event claimed: TRUE)
				(Print 232 20)
			)
		)
	)
)

(instance Smoke of Prop
	(properties
		y 137
		x 139
		z 43
		view 362
		loop 2
		cycleSpeed 1
	)
)

(instance Ash of Prop
	(properties
		y 137
		x 143
		view 362
		loop 6
	)
)

(instance rHead of Prop
	(properties
		y 135
		x 178
		z 42
		view 382
		loop 4
		cycleSpeed 1
	)
)
