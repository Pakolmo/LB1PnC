;;; Sierra Script 1.0 - (do not remove this comment)
(script# 276) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	desk 0
)
(synonyms
	(attorney person fellow)
)

(local
	talkCount
	askCount
	temp7
)
(instance Clarence of Prop ;Prop
	(properties
		y 138
		x 267
		view 411
	)
	
	(method (handleEvent event)
	

	
		(cond 
			(
				(and
					(not (& global207 $0040))
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
				
;;;				(|= global207 $0040)
				(= global207 (| global207 $0040))
				(= theTalker talkCLARENCE)
				(event claimed: TRUE)
				(Say 0 276 0)
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
				(event claimed: TRUE)
				(Print 276 1)
			)
		)
	)
)

(instance cHead of Prop ;Prop
	(properties
		y 99
		x 268
		view 411
		loop 1
	)
	
	(method (handleEvent event)
		(cond 
			(
				(and
					(not (& global207 $0040))
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
;;;				(|= global207 $0040)
				(= global207 (| global207 $0040))
				(= theTalker talkCLARENCE)
				(event claimed: TRUE)
				(Say 0 276 0)
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
				(event claimed: TRUE)
				(Print 276 1)
			)
		)
	)
)

(instance desk of Region ;Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(= global195 64)
		(cHead setPri: 10 init:)
		(Clarence init:)
		(self setScript: noteBook)
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
								(DoVerb {ask Clarence about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Jules})
							)											
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about blaze})
							)							
						
						
						
						
						(996
							(DoVerb {converse Clarence})
						)	
						(998
													(= temp7
;;;									(PrintSpecial
;;;										{ }
;;;										#button {Examine desk} 1
;;;										#button {Examine Notebook} 2
;;;										#button {Examine in Notebook} 3									
;;;									)
									(PrintSpecial
										{ }
										#button {Examinar escritorio} 1
										#button {Examinar libreta} 2
										#button {Fisgar en libreta} 3									
									)
										)
									

								(switch temp7
									(1		
		
										(DoVerb {examine desk})
									)
									(2

										(DoVerb {examine notebook})
									)
									(3

										(DoVerb {examine in notebook})
									)
									(else
										(event claimed: FALSE)
									)
								)
									)
									(else
										(event claimed: FALSE)
									)
;;;							(cond 
;;;								(
;;;									
;;;										(not (& global207 $0040))
;;;										
;;;									
;;;									(|= global207 $0040)
;;;									(= theTalker talkCLARENCE)
;;;									(event claimed: TRUE)
;;;									(Say 0 276 0)
;;;								)
;;;								(
;;;									
;;;										(& global207 $0040)
;;;										
;;;									
;;;									(event claimed: TRUE)
;;;									(Print 276 1)
;;;								)
;;;							)
;;;						)
;;;						(else
;;;							(event claimed: FALSE)
;;;						)
;;;					)
;;;			)
				
				)
	)
)
)

	
		
	
	
	
;;;	DONT WORK ALONE.
;;;			
;;;		(if (ClickedOnObj desk (event x?) (event y?)) 
;;;			(event claimed: TRUE)
;;;					(switch theCursor
;;;						(998
;;;						(= temp7
;;;;;;									(PrintSpecial
;;;;;;										{ }
;;;;;;										#button {Examine desk} 1
;;;;;;										#button {Examine Notebook} 2
;;;;;;										#button {Examine in Notebook} 3									
;;;;;;									)
;;;									(PrintSpecial
;;;										{ }
;;;										#button {Examinar escritorio} 1
;;;										#button {Examinar libreta} 2
;;;										#button {Fisgar en libreta} 3									
;;;									)
;;;										)
;;;									
;;;
;;;								(switch temp7
;;;									(1		
;;;		
;;;										(DoVerb {examine desk})
;;;									)
;;;									(2
;;;
;;;										(DoVerb {examine notebook})
;;;									)
;;;									(3
;;;
;;;										(DoVerb {examine in notebook})
;;;									)
;;;								)
;;;									)
;;;									(else
;;;										(event claimed: FALSE)
;;;									)
;;;										
;;;						)
;;;						)
;;;						
;;;							
;;;			)
;;;				)
;;;			
;;;		
;;;		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(super handleEvent: event)
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(= theTalker talkCLARENCE)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '/attorney')
							(Print 276 1)
						)
						((Said '/desk')
							(Print 276 2)
						)
						((Said '<in/notebook')
							(Print 276 3)
						)
						((Said '/notebook')
							(Print 276 4)
						)
					)
				)
				((Said 'ask//*<about')
					(switch askCount
						(0
							(Say 1 276 5)
							(++ askCount)
						)
						(1
							(Print 276 6)
						)
					)
				)
				((Said 'tell//*<about')
					(Print 276 7)
				)
				((Said 'hold/*')
					(if (and theInvItem haveInvItem)
						(Print 276 8)
					else
						(DontHave)
					)
				)
				((Said 'deliver/*')
					(if (and theInvItem haveInvItem)
						(Print 276 9)
					else
						(DontHave)
					)
				)
				((Said '/attorney>')
					(cond 
						((Said 'converse')
							(switch talkCount
								(0 (Say 1 276 10))
								(1 (Say 1 276 11))
								(2 (Say 1 276 12))
								(else  (Print 276 13))
							)
							(++ talkCount)
						)
						((Said 'hear') (Print 276 14))
						((Said 'get') (Print 276 15))
						((Said 'kill') (Print 276 16))
						((Said 'kiss') (Print 276 17))
						((Said 'embrace') (Print 276 18))
						((Said 'flirt') (Print 276 19))
					)
				)
				((Said 'get,open/notebook') (Print 276 20))
				((Said 'read/notebook') (Print 276 3))
			)
		)
	)
)

(instance noteBook of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
					((not (& global118 $0008))
						(= global118 (| global118 $0008))
;;;						(|= global118 $0008)
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
				(cHead loop: 5 cel: 0 cycleSpeed: 3 setCycle: EndLoop)
				(Clarence cycleSpeed: 1 setCycle: Forward)
				(= seconds (Random 5 12))
			)
			(2
				(Clarence setCycle: 0)
				(cHead setCycle: BegLoop)
				(= seconds (Random 3 5))
			)
			(3
				(cHead loop: 1 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 5))
			)
			(4
				(cHead setCycle: BegLoop)
				(= seconds (Random 3 5))
			)
			(5
				(switch (Random 1 2)
					(1 (= state 0))
					(2 (= state 2))
				)
				(= seconds (Random 3 5))
			)
		)
	)
)
;;;(instance desk of Actor ;RPicView
;;;	(properties
;;;		y 135
;;;		x 283
;;;		view 148
;;;		loop 1
;;;		cel 8
;;;		priority 10
;;;	)
;;;)