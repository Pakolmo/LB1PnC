;;; Sierra Script 1.0 - (do not remove this comment)
(script# 274) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	trunk 0
)
(synonyms
	(lil person girl)
)

(local
	talkCount
	local1
	askCount
	temp7
)
(instance trunk of Region
	
	(method (init)
		(super init:)
		(if (not (& global118 $0002))
			(LoadMany FONT 4 41)
			(LoadMany 143 406)
			(Load VIEW 642)
			(LoadMany SOUND 29 94 95 96)
		)
		(LHead setPri: 11 ignoreActors: TRUE)
		(suit2 setPri: 11 ignoreActors: TRUE init: stopUpd:)
		(Lillian setPri: 11 ignoreActors: TRUE init:)
		(= global195 32)
		(self setScript: suitCase)
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
				
			(if (ClickedOnObj Lillian (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell lillian about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell lillian about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell lillian about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell lillian about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell lillian about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell lillian about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell lillian about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell lillian about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell lillian about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell lillian about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell lillian about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell lillian about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell lillian about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell lillian about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell lillian about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell lillian about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell lillian about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell lillian about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell lillian about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell lillian about diary})						
					)
					(621 ;crank_
						(DoVerb {tell lillian about crank})						
					)
					(612 ;cane_
						(DoVerb {tell lillian about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell lillian about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell lillian about handkerchief})
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
								(DoVerb {ask lillian about gertie})
							)
							(2
								(DoVerb {tell lillian about gertie})
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
								(DoVerb {ask lillian about Celie})
							)
							(2
								(DoVerb {tell lillian about Celie})
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
								(DoVerb {ask lillian about gloria})
							)
							(2
								(DoVerb {tell lillian about gloria})
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
								(DoVerb {ask lillian about ethel})
							)
							(2
								(DoVerb {tell lillian about ethel})
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
								(DoVerb {ask lillian about fifi})
							)
							(2
								(DoVerb {tell lillian about fifi})
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
								(DoVerb {ask lillian about lillian})
							)
							(2
								(DoVerb {tell lillian about lillian})
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
								(DoVerb {ask lillian about Clarence})
							)
							(2
								(DoVerb {tell lillian about clarence})
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
								(DoVerb {ask lillian about Wilbur})
							)
							(2
								(DoVerb {tell lillian about Wilbur})
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
								(DoVerb {ask lillian about rudolph})
							)
							(2
								(DoVerb {tell lillian about rudolph})
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
								(DoVerb {ask lillian about colonel})
							)
							(2
								(DoVerb {tell lillian about colonel})
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
								(DoVerb {ask lillian about Jeeves})
							)
							(2
								(DoVerb {tell lillian about Jeeves})
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
								(DoVerb {ask lillian about beauregard})
							)
							(2
								(DoVerb {tell lillian about beauregard})
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
								(DoVerb {ask lillian about polly})
							)
							(2
								(DoVerb {tell lillian about polly})
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
								(DoVerb {ask lillian about blaze})
							)
							(2
								(DoVerb {tell lillian about blaze})
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
								(DoVerb {ask lillian about sarah})
							)
							(2
								(DoVerb {tell lillian about sarah})
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
								(DoVerb {ask lillian about crouton})
							)
							(2
								(DoVerb {tell lillian about crouton})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)											
							
														
						(996 ;talk
							(DoVerb {converse lillian})
						)
						(998	
							(DoVerb {Examine lillian})
						)
						(995
							(= temp7
												(Print
													{Lillian}
													#button {Coger} 1
													#button {Matar} 2								
													#button {Besar} 3
													#button {Abrazar} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get lillian})
												)
												(2 
													(DoVerb {kill lillian})
												)		
												(3 
													(DoVerb {kiss lillian})
												)		
												(4 
													(DoVerb {embrace lillian})
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
		(super handleEvent: event)
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance suitCase of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
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
				(if (== gCurRoomNum_2 5)
					(= cycles 1)
					(= state 3)
				else
					(Lillian cycleSpeed: 1 setCycle: Forward)
					(++ gCurRoomNum_2)
					(= seconds 2)
				)
			)
			(2
				(Lillian loop: 0 cel: 0 setCycle: EndLoop self)
			)
			(3
				(if (not gCurRoomNum_2)
					(Print 274 0)
				)
				(= cycles 1)
			)
			(4
				(LHead init: setScript: headActions)
				(= cycles 1)
			)
			(5
				(Lillian loop: 4 cycleSpeed: 1 setCycle: EndLoop)
				(= seconds (Random 6 15))
			)
			(6
				(Lillian setCycle: BegLoop)
				(= seconds (Random 6 15))
				(= state 4)
			)
		)
	)
)

(instance headActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LHead setCycle: EndLoop)
				(= seconds (Random 6 15))
			)
			(1
				(LHead setCycle: BegLoop)
				(= seconds (Random 6 15))
				(= state -1)
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 149
		x 270
		view 511
		loop 3
	)
	
	(method (handleEvent event)
		(= theTalker talkLILLIAN)
		(cond 
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
;;;				(|= global207 $0020)
				(= global207 (| global207 $0020))				
				(= theTalker talkLILLIAN)
				(event claimed: TRUE)
				(Say 0 274 1)
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
				(event claimed: TRUE)
				(Print 274 2)
			)
			((Said 'ask//*<about')
				(switch askCount
					(0
						(Say 1 274 3)
						(++ askCount)
					)
					(1
						(Print 274 4)
					)
				)
			)
			((Said 'tell//*<about')
				(Print 274 5)
			)
			((Said 'deliver/*')
				(if (and theInvItem haveInvItem)
					(Print 274 6)
				else
					(DontHave)
				)
			)
			((Said 'hold/*')
				(if (and theInvItem haveInvItem)
					(Print 274 7)
				else
					(DontHave)
				)
			)
			((Said '/lil>')
				(cond 
					((Said 'converse')
						(switch talkCount
							(0 (Say 1 274 8))
							(1 (Say 1 274 9))
							(2 (Say 1 274 10))
							(3 (Say 1 274 11))
							(4 (Say 1 274 12))
							(else  (Print 274 13))
						)
						(++ talkCount)
					)
					((Said 'hear') (Print 274 14))
					((Said 'get') (Print 274 15))
					((Said 'kill') (Print 274 16))
					((Said 'kiss') (Print 274 17))
					((Said 'embrace') (Print 274 18))
				)
			)
		)
	)
)

(instance suit2 of Prop
	(properties
		y 137
		x 262
		view 511
		loop 2
	)
)

(instance LHead of Prop
	(properties
		y 148
		x 273
		z 32
		view 511
		loop 5
	)
)
