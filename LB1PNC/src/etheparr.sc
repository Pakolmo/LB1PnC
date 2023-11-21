;;; Sierra Script 1.0 - (do not remove this comment)
(script# 238)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	etheparr 0
)
(synonyms
	(ethel person girl)
)

(local
	talkCount
	chatCount
	temp7
)
(procedure (EthelPrint)
	(Ethel loop: 1 setCycle: Forward)
	(Print &rest
		#at 80 145
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(procedure (ParrotPrint)
	(Print &rest
		#at 171 145
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance etheparr of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(= global195 8)
		(Ethel init: setScript: ethelParrot)
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
			
				
				(if (ClickedOnObj Ethel (event x?) (event y?)) 
					
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
								(DoVerb {ask ethel about gertrude})
							)
							(2
								(DoVerb {tell ethel about gertrude})
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
								(DoVerb {ask ethel about Celie})
							)
							(2
								(DoVerb {tell ethel about Celie})
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
								(DoVerb {ask ethel about gloria})
							)
							(2
								(DoVerb {tell ethel about gloria})
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
								(DoVerb {ask ethel about ethel})
							)
							(2
								(DoVerb {tell ethel about ethel})
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
								(DoVerb {ask ethel about fifi})
							)
							(2
								(DoVerb {tell ethel about fifi})
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
								(DoVerb {ask ethel about lillian})
							)
							(2
								(DoVerb {tell ethel about lillian})
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
								(DoVerb {ask ethel about Clarence})
							)
							(2
								(DoVerb {tell ethel about clarence})
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
								(DoVerb {ask ethel about Wilbur})
							)
							(2
								(DoVerb {tell ethel about Wilbur})
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
								(DoVerb {ask ethel about rudolph})
							)
							(2
								(DoVerb {tell ethel about rudolph})
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
								(DoVerb {ask ethel about colonel})
							)
							(2
								(DoVerb {tell ethel about colonel})
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
								(DoVerb {ask ethel about Jules})
							)
							(2
								(DoVerb {tell ethel about Jules})
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
								(DoVerb {ask ethel about beauregard})
							)
							(2
								(DoVerb {tell ethel about beauregard})
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
								(DoVerb {ask ethel about polly})
							)
							(2
								(DoVerb {tell ethel about polly})
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
								(DoVerb {ask ethel about blaze})
							)
							(2
								(DoVerb {tell ethel about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
						
						(994		
							(DoVerb {hear ethel})
						)													
						(998		
							(DoLook {ethel})
						)
						(996
							(DoVerb {Talk Ethel})	
						)	
						(else
						
							(event claimed: FALSE)
						)
					)

				)
				
			)
		)		
		
		
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(if (and (== (event type?) saidEvent) (Said '/drink,glass>'))
			(cond 
				((Said 'examine')
					(Print 238 0)
				)
				((Said 'get')
					(Print 238 1)
				)
			)
		)
		(return (super handleEvent: event))
	)
)

(instance ethelParrot of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel loop: 0 setCycle: EndLoop self)
			)
			(1
				(User canInput: FALSE)
				(if chatCount
					(switch chatCount
						(1 (EthelPrint 238 2))
						(2 (EthelPrint 238 3))
						(3 (ParrotPrint 238 4))
						(4 (EthelPrint 238 5))
						(else  (EthelPrint 238 6))
					)
				else
					(EthelPrint 238 7)
				)
				(= seconds 5)
			)
			(2
				(Ethel setCycle: 0)
				(if chatCount
					(switch chatCount
						(1 (ParrotPrint 238 8))
						(2 (ParrotPrint 238 9))
						(3 (EthelPrint 238 10))
						(4 (ParrotPrint 238 11))
						(else  (ParrotPrint 238 12))
					)
				else
					(ParrotPrint 238 13)
				)
				(++ chatCount)
				(= seconds 3)
			)
			(3
				(User canInput: TRUE)
				(cls)
				(Ethel loop: 0 cel: 3 setCycle: BegLoop)
				(if (< (Random 1 100) 20)
					(= state 6)
				)
				(= seconds 10)
			)
			(4
				(Ethel loop: 2 cel: 0 cycleSpeed: 2 setCycle: EndLoop)
				(= seconds 3)
			)
			(5
				(Ethel setCycle: BegLoop self)
			)
			(6
				(if (< (Random 1 100) 20)
					(= state -1)
				)
				(= seconds 10)
			)
			(7
				(Ethel loop: 3 setCycle: EndLoop)
				(if (< (Random 1 100) 20)
					(= state -1)
				)
				(= seconds (Random 6 12))
			)
			(8
				(Ethel loop: 4 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 6))
			)
			(9
				(Ethel loop: 5 cel: 0 setCycle: EndLoop)
				(if (< (Random 1 100) 20)
					(= state -1)
				else
					(= state 3)
				)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance Ethel of Actor
	(properties
		y 102
		x 168
		view 329
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(= theTalker talkETHEL)
		(cond 
			(
				(or
					(Said 'ask,tell/parrot>')
					(Said 'hold,deliver/*/parrot>')
					(Said 'hold,deliver/*<parrot>')
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/ethel'))
				(if (not (& global207 $0008))
;;;					(|= global207 $0008)
					(= global207 (| global207 $0008))
					(Say 0 238 14)
				else
					(Print 238 15)
				)
				(event claimed: TRUE)
			)
			((Said 'ask,tell//*<about')
				(switch (Random 1 8)
					(1 (Say 1 238 16))
					(2 (Say 1 238 17))
					(3 (Say 1 238 18))
					(4 (Print 238 19))
					(5 (Say 1 238 20))
					(6 (Say 1 238 21))
					(7 (Say 1 238 22))
					(else  (Print 238 23))
				)
			)
			((or (Said 'deliver/*<ethel') (Said 'deliver/*[/ethel]'))
				(if (and theInvItem haveInvItem)
					(Print 238 24)
				else
					(DontHave)
				)
			)
			(
			(or (Said 'hold/*<ethel') (Said 'hold/*[/ethel]'))
				(if (and theInvItem haveInvItem)
					(Print 238 25)
				else
					(DontHave)
				)
			)
			((Said '/ethel>')
				(cond 
					((Said 'converse')
						(switch talkCount
							(0
								(Print 238 26)
							)
							(1
								(Say 1 238 27)
								(Say 1 238 28)
							)
							(2
								(Say 1 238 29)
								(= theTalker talkLAURA)
								(Say 1 238 30)
								(= theTalker talkETHEL)
								(Say 1 238 31)
							)
							(3
								(Say 1 238 32)
								(Say 1 238 33)
								(Print 238 34)
							)
							(4
								(Say 1 238 35)
								(= theTalker talkLAURA)
								(Say 1 238 36)
							)
							(else
								(Print 238 37)
							)
						)
						(++ talkCount)
					)
					((Said 'hear')
						(Print 238 38)
					)
					((Said 'get')
						(Print 238 39)
					)
					((Said 'kill')
						(Print 238 40)
					)
					((Said 'kiss')
						(Print 238 41)
					)
					((Said 'embrace')
						(Print 238 42)
					)
				)
			)
		)
	)
)
