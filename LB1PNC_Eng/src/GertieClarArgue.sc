;;; Sierra Script 1.0 - (do not remove this comment)
(script# 217)
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
	GertieClarArgue 0
)
(synonyms
	(butt cigarette)
	(gertie girl)
	(attorney fellow)
)

(local
	gertieTalkCount
	clarenceTalkCount
	local2
	local3
	local4
	local5
	argueCount
	temp7
)
(procedure (GertiePrint)
	(Gertie loop: 2 cycleSpeed: 1 setCycle: Forward)
	(Clarence setCycle: 0)
	(Print &rest
		#at 10 140
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(procedure (ClarPrint)
	(Gertie loop: 1 cel: 1 stopUpd:)
	(Clarence loop: 3 cel: 0 cycleSpeed: 1 setCycle: Forward)
	(Print &rest
		#at 101 140
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance GertieClarArgue of Region
	
	(method (init)
		(super init:)
		(if (not (& global173 $0002))
			(LoadMany FONT 4 41)
			(Load VIEW 642)
			(LoadMany SOUND 29 94 95 96)
			(Load SCRIPT 406)
		)
		(LoadMany 143 243 218)
		(LoadMany 142 7 1)
		(= global208 64)
		(= [global377 6] 218)
		(= [global377 0] 216)
		(ClarAss init: stopUpd:)
		(Clarence setPri: 6 init:)
		(Smoke setPri: 6 init: hide:)
		(ego observeBlocks: gBlock)
		(if (not (& global173 $0002))
			(LoadMany 143 216)
			(Gertie init:)
			(self setScript: argue)
;;;			(|= global208 $0001)
			(= global208 (| global208 $0001))
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(if (and (not (& global173 $0002)) (== [global368 1] 0))
			(= [global368 1] 1800)
		)
		(DisposeScript 204)
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
		
				(if (ClickedOnObj Clarence (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Clarence about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Clarence about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Clarence about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Clarence about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Clarence about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Clarence about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Clarence about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Clarence about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Clarence about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Clarence about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Clarence about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Clarence about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Clarence about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Clarence about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Clarence about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Clarence about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Clarence about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Clarence about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Clarence about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Clarence about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Clarence about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Clarence about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Clarence about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Clarence about handkerchief})
					)
											
					
						
					
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
												(= temp7
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about gertie})
							)
							(2
								(DoVerb {tell Clarence about gertie})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about Celie})
							)
							(2
								(DoVerb {tell Clarence about Celie})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about gloria})
							)
							(2
								(DoVerb {tell Clarence about gloria})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about ethel})
							)
							(2
								(DoVerb {tell Clarence about ethel})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about fifi})
							)
							(2
								(DoVerb {tell Clarence about fifi})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about lillian})
							)
							(2
								(DoVerb {tell Clarence about lillian})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about Clarence})
							)
							(2
								(DoVerb {tell Clarence about clarence})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about Wilbur})
							)
							(2
								(DoVerb {tell Clarence about Wilbur})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about rudolph})
							)
							(2
								(DoVerb {tell Clarence about rudolph})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about colonel})
							)
							(2
								(DoVerb {tell Clarence about colonel})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about Jeeves})
							)
							(2
								(DoVerb {tell Clarence about Jeeves})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about beauregard})
							)
							(2
								(DoVerb {tell Clarence about beauregard})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about polly})
							)
							(2
								(DoVerb {tell Clarence about polly})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about blaze})
							)
							(2
								(DoVerb {tell Clarence about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)	

						
												(944 ;Sarah
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about sarah})
							)
							(2
								(DoVerb {tell Clarence about sarah})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
							
							(945 ;Crouton
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask Clarence about crouton})
							)
							(2
								(DoVerb {tell Clarence about crouton})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																				
						(996 ;talk
							(DoVerb {converse Clarence})
						)
						(994
								(DoVerb {hear Clarence})
						)	
						(998
								(= temp7
							(PrintSpecial
								{Clarence}
								#button {Examine} 1
								#button {Examine cigar} 2
;;;								#button {Examinar} 1
;;;								#button {Cigarro} 2
							)
							)
						
						(switch temp7
							(1
							    (DoVerb {examine attorney})
							)
							(2
								(DoVerb {examine cigar})
							)
							(else
								(event claimed: FALSE)
							)
										
						)
						)(else
								(event claimed: FALSE)
							)
					)
				)
	
	
			
				(if (ClickedOnObj Gertie (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell ethel about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell ethel about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell ethel about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell ethel about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell ethel about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell ethel about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell ethel about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell ethel about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell ethel about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell ethel about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell ethel about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell ethel about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell ethel about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell ethel about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell ethel about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell ethel about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell ethel about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell ethel about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell ethel about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell ethel about diary})						
					)
					(621 ;crank_
						(DoVerb {tell ethel about crank})						
					)
					(612 ;cane_
						(DoVerb {tell ethel about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell ethel about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell ethel about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear gertie})
							)						
						
								
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
												(= temp7
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about gertie})
							)
							(2
								(DoVerb {tell gertie about gertie})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about Celie})
							)
							(2
								(DoVerb {tell gertie about Celie})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about gloria})
							)
							(2
								(DoVerb {tell gertie about gloria})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about ethel})
							)
							(2
								(DoVerb {tell gertie about ethel})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about fifi})
							)
							(2
								(DoVerb {tell gertie about fifi})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about lillian})
							)
							(2
								(DoVerb {tell gertie about lillian})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about Clarence})
							)
							(2
								(DoVerb {tell gertie about clarence})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about Wilbur})
							)
							(2
								(DoVerb {tell gertie about Wilbur})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about rudolph})
							)
							(2
								(DoVerb {tell gertie about rudolph})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about colonel})
							)
							(2
								(DoVerb {tell gertie about colonel})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about Jeeves})
							)
							(2
								(DoVerb {tell gertie about Jeeves})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about beauregard})
							)
							(2
								(DoVerb {tell gertie about beauregard})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about polly})
							)
							(2
								(DoVerb {tell gertie about polly})
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
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about blaze})
							)
							(2
								(DoVerb {tell gertie about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)

						
												(944 ;Sarah
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about sarah})
							)
							(2
								(DoVerb {tell gertie about sarah})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
							
							(945 ;Crouton
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
								{Ask or Tell}
								#button {Ask} 1
								#button {Tell} 2
;;;								{Preguntar o Hablar de}
;;;								#button {Preguntar} 1
;;;								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask gertie about crouton})
							)
							(2
								(DoVerb {tell gertie about crouton})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																		
						(998		
							(DoLook {gertie})
						)
						(996
							(DoVerb {Talk gertie})	
						)	
						(else
						
							(event claimed: FALSE)
						)
					)

				)
			)
						)		

		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '/butt')
								(Bset fExaminedCigar)
								(Print 217 0)
							)
							((Said '/drink,glass')
								(Print 217 1)
							)
						)
					)
					((Said 'hear/attorney,gertie')
						(Print 217 2)
					)
					((Said 'get/butt')
						(Print 217 3)
					)
					((Said 'get/drink,glass')
						(Print 217 4)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance argue of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0002))
;;;						(|= global118 $0002)
						(= global118 (| global118 $0002))						
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
				(if (== (= argueCount (& global172 $7fff)) global172)
					(if (< global172 10)
						(++ global172)
					else
						(= global172 -32767)
					)
				else
					(switch argueCount
						(1 (= global172 -32766))
						(2 (= global172 -32763))
						(5 (= global172 -32762))
						(6 (= global172 -32759))
						(9 (= global172 -32758))
						(10 (= global172 -32767))
					)
				)
				(switch argueCount
					(0 (ClarPrint 217 5))
					(1 (GertiePrint 217 6))
					(2 (ClarPrint 217 7))
					(3 (GertiePrint 217 8))
					(4 (ClarPrint 217 9))
					(5 (GertiePrint 217 10))
					(6 (ClarPrint 217 11))
					(7 (GertiePrint 217 12))
					(8 (ClarPrint 217 13))
					(9 (GertiePrint 217 14))
					(10 (ClarPrint 217 15))
				)
				(= seconds 5)
			)
			(2
				(cls)
				(switch argueCount
					(0 (ClarPrint 217 16))
					(3 (GertiePrint 217 17))
					(7 (ClarPrint 217 18))
					(8 (GertiePrint 217 19))
					(else 
						(Clarence setCycle: 0)
						(Gertie loop: 1 cel: 1 stopUpd:)
					)
				)
				(= seconds 3)
			)
			(3
				(cls)
				(Gertie loop: 1 cel: 1 stopUpd: setScript: gertActions)
				(Clarence stopUpd: setScript: clarActions)
				(User canInput: TRUE)
				(client setScript: 0)
			)
		)
	)
)

(instance gertActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Gertie loop: 1 cel: 1 forceUpd:)
				(= seconds (Random 3 8))
			)
			(1
				(Gertie loop: 1 cel: 0 forceUpd:)
				(= state (Random -1 1))
				(= seconds (Random 3 8))
			)
			(2
				(Gertie loop: 0 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 5))
			)
			(3
				(Gertie loop: 0 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 8))
			)
			(4
				(Gertie loop: 3 setCycle: Forward)
				(= seconds (Random 3 8))
			)
			(5
				(Gertie setCycle: 0 stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance clarActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state 5)
				(= cycles 1)
			)
			(1
				(Clarence setLoop: 1 cel: 0 setCycle: EndLoop self)
				(= local3 (Random 1 3))
				(= local4 0)
			)
			(2
				(= seconds 2)
			)
			(3
				(Clarence setLoop: 4 cel: 1)
				(= cycles 1)
			)
			(4
				(Smoke cel: 0 setCycle: EndLoop self show:)
			)
			(5
				(if (< local4 local3)
					(++ local4)
					(Clarence cel: 0)
					(= cycles (= state 1))
				else
					(Smoke cel: 0 hide:)
					(Clarence setLoop: 5)
					(Clarence
						cel: (- (NumCels Clarence) 3)
						cycleSpeed: 2
						setCycle: BegLoop
					)
					(= seconds (Random 3 6))
				)
			)
			(6
				(Clarence setLoop: 2)
				(Clarence cel: (- (NumCels Clarence) 1))
				(= cycles 1)
			)
			(7
				(Clarence setCycle: BegLoop)
				(switch (Random 1 4)
					(1 (= state 0))
					(3 (= state 8))
				)
				(= seconds (Random 3 6))
			)
			(8
				(Clarence setCycle: EndLoop)
				(= seconds (Random 3 (= state 6)))
			)
			(9
				(Clarence setLoop: 9 cel: 0 setCycle: EndLoop)
				(= seconds (Random 1 2))
			)
			(10
				(Clarence setCycle: BegLoop)
				(= seconds (Random 3 6))
				(if (< seconds 5)
					(= state 0)
				else
					(= state 5)
				)
			)
		)
	)
)

(instance Gertie of Prop
	(properties
		y 103
		x 125
		view 342
	)
	
	(method (handleEvent event)
		(if (< (ego distanceTo: Gertie) (ego distanceTo: Clarence))
			(= global214 1)
		else
			(= global214 64)
		)
		(= theTalker talkGERTIE)
		(cond 
			((Said 'examine/people')
				(Print 217 20)
			)
			((Said 'examine,converse/person')
				(Print 217 21)
			)
			((Said 'converse/people')
				(Print 217 22)
			)
			((Said 'ask[/gertie]/attorney<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 4 217 23)
			)
			((Said 'converse/gertie')
				(switch gertieTalkCount
					(0 (Say 1 217 24))
					(1 (Say 1 217 25))
					(2 (Say 1 217 26))
					(else  (Say 1 217 27))
				)
				(++ gertieTalkCount)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0001)))
				(event claimed: TRUE)
				(DoLook {gertie})
			)
			(
				(and
					(& global207 $0001)
					(or (MousedOn self event shiftDown) (Said 'examine/gertie'))
				)
				(Print 217 28)
				(event claimed: TRUE)
			)
		)
	)
)

(instance Clarence of Prop
	(properties
		y 74
		x 171
		view 401
		loop 1
	)
	
	(method (handleEvent event)
		(= theTalker talkCLARENCE)
		(cond 
			((Said 'converse/attorney')
				(switch clarenceTalkCount
					(0 (Say 1 217 29))
					(1 (Say 1 217 30))
					(2 (Say 1 217 31))
					(else  (Say 1 217 32))
				)
				(++ clarenceTalkCount)
			)
			((Said 'ask[/attorney]/gertie<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 9 217 33)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0040)))
				(event claimed: TRUE)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
				(event claimed: TRUE)
				(Print 217 20)
			)
		)
	)
)

(instance ClarAss of Prop
	(properties
		y 102
		x 168
		view 401
		cel 2
	)
)

(instance Smoke of Prop
	(properties
		y 60
		x 167
		view 401
		loop 6
	)
)

(instance gBlock of Block
	(properties
		top 98
		left 115
		bottom 104
		right 140
	)
)
