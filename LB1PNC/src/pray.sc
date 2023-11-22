;;; Sierra Script 1.0 - (do not remove this comment)
(script# 279) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	pray 0
)
(synonyms
	(celie person girl)
)

(local
	talkCount
	temp7
)
(instance Celie of Prop
	(properties)
	
	(method (handleEvent event)
	
		
		
		
		(cond 
			(
			(and (MousedOn self event shiftDown) (not (& global207 $0002)))
;;;				(|= global207 $0002)
				(= global207 (| global207 $0002))
				(= theTalker talkCELIE)
				(event claimed: TRUE)
				(Say 0 279 0)
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event shiftDown) (Said 'examine/celie'))
				)
				(event claimed: TRUE)
				(Print 279 1)
			)
			((Said 'ask,tell//*<about')
				(Print 279 2)
			)
			((Said 'deliver,hold/*')
				(if (and theInvItem haveInvItem)
					(Print 279 3)
				else
					(DontHave)
				)
			)
			((Said '/celie>')
				(cond 
					((Said 'converse')
						(= theTalker talkCELIE)
						(switch talkCount
							(0 (Say 1 279 4))
							(1 (Say 1 279 5))
							(else  (Print 279 6))
						)
						(++ talkCount)
					)
					((Said 'get') (Print 279 7))
					((Said 'kill') (Print 279 8))
					((Said 'kiss') (Print 279 9))
					((Said 'embrace') (Print 279 10))
				)
			)
		)
	)
)

(instance pray of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(= global195 2)
		(if (not (& global118 $0008))
			(Load FONT 41)
			(LoadMany SOUND 29 94 95 96)
			(Load SCRIPT 406)
			(Load VIEW 642)
		)
		(Celie view: 481 loop: 0 posn: 142 105 init:)
		(self setScript: praying)
	)
	
	(method (doit)
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
				
				(if (ClickedOnObj Celie (event x?) (event y?)) 
					
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
						(DoVerb {tell celie about soup bone})						
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
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		(super handleEvent: event)
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance praying of Script
	
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
				(cls)
				(User canInput: TRUE)
				(Celie loop: 0 setCycle: EndLoop)
			)
			(2
				(User canInput: FALSE)
				(Celie setCycle: BegLoop self)
			)
			(3
				(Celie loop: 1 setCycle: Forward)
				(= state 0)
				(= seconds 5)
			)
		)
	)
)
