;;; Sierra Script 1.0 - (do not remove this comment)
(script# 257)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	lillRead 0
)
(synonyms
	(lil person girl)
)

(local
	talkCount
	readCount
	temp7
)
(procedure (LillPrint)
	(Print &rest
		#at 40 10
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance lillRead of Region
	
	(method (init)
		(super init:)
		(if (not (& global118 $0001))
			(LoadMany SOUND 29 94 95 96)
			(Load FONT 41)
			(Load SCRIPT 406)
			(Load VIEW 642)
		)
		(Load FONT 4)
		(LoadMany 143 406 243 288)
		(Load VIEW 905)
		(= global208 32)
		(= [global377 5] 288)
		(Lillian init:)
		(LHead init: stopUpd:)
		(Book init: stopUpd:)
		(self setScript: reading)
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
	
			(if (ClickedOnObj Book (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {get book}) 
						)
						(998
							(DoVerb {examine book}) 
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
	
	
	
				
			(if (or (ClickedOnObj Lillian (event x?) (event y?)) 
				(ClickedOnObj LHead (event x?) (event y?)) 	)
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
						(994
							(DoVerb {hear lillian})	
						)
							
							
														
						(996 ;talk
							(DoVerb {converse lillian})
						)
						(998	
							(DoVerb {examine lillian})
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
							(Say 0 257 25)
							)
						)
						)
						(995
							(= temp7
												(Print
													{Lillian}
													#button {Take} 1
													#button {Kill} 2								
													#button {Kiss} 3
													#button {Embrace} 4
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
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '/book')
								(if (< (ego distanceTo: Lillian) 40)
									(Print 257 0)
								else
									(NotClose)
								)
							)
							((Said '/doll')
								(Print 257 1)
							)
						)
					)
					((Said 'get>')
						(cond 
							((Said '/book')
								(Print 257 2)
							)
							((Said '/doll')
								(Print 257 3)
							)
						)
					)
					((Said 'read/book')
						(if (< (ego distanceTo: Lillian) 40)
							(Print 257 0)
						else
							(NotClose)
						)
					)
				)
			else
				0
			)
		)
	)
)

(instance reading of Script
	
	(method (doit)
		(if (and (== state 1) (== (Lillian cel?) 4))
			(Book hide:)
		)
		(super doit:)
	)
	
	(method (changeState newState)

		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
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
				(Lillian loop: 6 setCycle: BegLoop self)
			)
			(2
				(LHead loop: 5 setCycle: Forward)
				(User canInput: FALSE)
				(switch readCount
					(0 (LillPrint 257 4))
					(1 (LillPrint 257 5))
					(2 (LillPrint 257 6))
					(3 (LillPrint 257 7))
					(4 (LillPrint 257 8))
					(5 (LillPrint 257 9))
					(6 (LillPrint 257 10))
					(7 (LillPrint 257 11))
					(8 (LillPrint 257 12))
					(else  (LillPrint 257 13))
				)
				(if (< readCount 9)
					(++ readCount)
				else
					(= readCount 0)
				)
				(= seconds 4)
			)
			(3
				(LHead loop: 5 setCycle: 0)
				(cls)
				(User canInput: TRUE)
				(= seconds 3)
			)
			(4
				(Lillian loop: 2 setCycle: EndLoop)
				(if (< (Random 1 100) 15) (= state 3))
				(= seconds (Random 6 12))
			)
			(5
				(LHead loop: 3 setCycle: EndLoop)
				(= seconds (Random 3 8))
			)
			(6
				(LHead setCycle: BegLoop)
				(if (< (Random 1 100) 25)
					(= state 3)
				else
					(= state 1)
				)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance Lillian of Actor
	(properties
		y 141
		x 187
		view 506
		loop 6
		cel 5
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'converse/lil')
				(= theTalker talkLILLIAN)
				(switch talkCount
					(0 (Say 1 257 14))
					(1 (Say 1 257 15))
					(2 (Say 1 257 16))
					(else  (Print 257 17))
				)
				(++ talkCount)
			)
			((Said 'tell,ask/lil')
				(Print 257 18)
			)
			((Said 'deliver,hold/lil')
				(Print 257 19)
			)
			((Said 'hear/lil')
				(Print 257 20)
			)
			((Said 'get/lil')
				(Print 257 21)
			)
			((Said 'kill/lil')
				(Print 257 22)
			)
			((Said 'kiss/lil')
				(Print 257 23)
			)
			((Said 'embrace/lil')
				(Print 257 24)
			)
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
;;;				(|= global207 $0020)
				(= global207 (| global207 $0020))
				(= theTalker talkLILLIAN)
				(event claimed: TRUE)
				(Say 0 257 25)
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
				(event claimed: TRUE)
				(Print 257 26)
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 141
		x 189
		z 33
		view 506
		loop 3
	)
)

(instance Book of Prop
	(properties
		y 123
		x 177
		view 163
		loop 2
		cel 2
	)
)
