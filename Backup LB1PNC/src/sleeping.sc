;;; Sierra Script 1.0 - (do not remove this comment)
(script# 224)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	sleeping 0
)
(synonyms
	(gertie person girl)
)

(local
	talkCount
	temp7
)
(instance snoring of Sound)

(instance sleeping of Region
	
	(method (init)
		(super init:)
		(= global195 1)
		(LoadMany FONT 41)
		(LoadMany VIEW 642 900)
		(LoadMany SOUND 29 94 95 96 114 115)
		(LoadMany 143 406)
		(Gertie setPri: 6 setCycle: Forward init:)
		(snores setPri: 6 init:)
	)
	
	(method (doit)
		(super doit:)
		(if (and global216 (not (& global118 $0004)))
;;;			(|= global118 $0004)
			(= global118 (| global118 $0004))		
			(self setScript: (ScriptID 406 0))
		)
		(if
			(and
				(== (snoring prevSignal?) -1)
				(== (snoring number?) 114)
			)
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
		(if (== (Gertie cel?) 0)
			(snoring number: 114 loop: 1 play:)
			(snores cel: 0 setCycle: EndLoop)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(= theTalker talkGERTIE)
			(cond 
				((Said 'deliver,hold/*')
					(if (and theInvItem haveInvItem)
						(Print 224 0)
					else
						(DontHave)
					)
				)
				((or (Said 'ask,tell//*<about') (Said 'converse'))
					(switch talkCount
						(0
							(Say 1 224 1)
							(++ talkCount)
						)
						(1
							(Print 224 0)
						)
					)
					(event claimed: TRUE)
				)
				((Said '/gertie>')
					(cond 
						((Said 'examine')
							(if (& global207 $0001)
								(Print 224 2)
							else
;;;								(|= global207 $0001)
								(= global207 (| global207 $0001))
								(Say 0 224 3)
							)
						)
						((Said 'hear')
							(Print 224 4)
						)
						((Said 'awaken,kill,embrace,kiss,get,hit,move')
							(Print 224 5)
						)
					)
				)
			)
		)
	)
)

(instance Gertie of Prop
	(properties
		y 86
		x 214
		view 344
		cycleSpeed 16
	)
	
	(method (handleEvent event)

		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(cond 
			((Said 'examine[<at]/bed')
				(Print 224 2)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(DoLook {gertie})
			)
		)
	)
)

(instance snores of Prop
	(properties
		y 68
		x 228
		view 344
		loop 1
		cycleSpeed 1
	)
)
