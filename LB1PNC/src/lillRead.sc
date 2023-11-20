;;; Sierra Script 1.0 - (do not remove this comment)
(script# 282)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
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
	local1
	local2
	temp7
)
(instance lillRead of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(= global195 32)
		(if (not (& global118 $0002))
			(Load FONT 41)
			(LoadMany SOUND 29 94 95 96)
			(Load SCRIPT 406)
			(Load VIEW 642)
		)
		(Lillian init: stopUpd:)
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
								(DoVerb {ask lillian about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about Jules})
							)
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask lillian about blaze})
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
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'play[/doll]')
						(Print 282 0)
					)
					((Said 'examine/blackboard')
						(Print 282 1)
					)
					((Said 'get/blackboard')
						(Print 282 2)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance reading of Script
	
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
				(Lillian loop: 8 cycleSpeed: 1 setCycle: Forward)
				(if (not local1)
					(++ local1)
					(Print 282 3 #dispose)
				)
				(if (< (Random 1 100) 51)
					(= state 4)
				)
				(= seconds (Random 3 12))
			)
			(2
				(cls)
				(Lillian loop: 1 setCycle: EndLoop)
				(if (< (Random 1 100) 51)
					(= state 5)
				)
				(= seconds (Random 3 12))
			)
			(3
				(Lillian loop: 0 setCycle: Forward)
				(Print 282 4 #dispose)
				(= seconds (Random 3 12))
			)
			(4
				(cls)
				(Lillian loop: 1 cel: 2 setCycle: BegLoop)
				(cond 
					((< (= local2 (Random 1 100)) 31) (= state 0))
					((> local2 70) (= state 1))
				)
				(= seconds (Random 3 12))
			)
			(5
				(cls)
				(Lillian loop: 7 setCycle: Forward)
				(if (< (Random 1 100) 51)
					(= state 0)
				else
					(= state 1)
				)
				(= seconds (Random 3 12))
			)
			(6
				(Lillian loop: 4 setCycle: Forward)
				(= seconds (Random (= state 3) 12))
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 141
		x 187
		view 506
		loop 8
	)
	
	(method (handleEvent event)
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
				(Say 0 282 5)
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event shiftDown) (Said 'examine/lil'))
				)
				(event claimed: TRUE)
				(Print 282 6)
			)
			((Said 'tell,ask//*<about')
				(Print 282 7)
			)
			((Said 'deliver,hold/*')
				(if (and theInvItem haveInvItem)
					(Print 282 8)
				else
					(DontHave)
				)
			)
			((Said '/lil>')
				(cond 
					((Said 'converse')
						(= theTalker talkLILLIAN)
						(switch talkCount
							(0 (Say 1 282 9))
							(1 (Say 1 282 10))
							(2 (Say 1 282 11))
							(3 (Say 1 282 12))
							(4 (Say 1 282 13))
							(else  (Print 282 14))
						)
						(++ talkCount)
					)
					((Said 'get')
						(Print 282 15)
					)
					((Said 'kill')
						(Print 282 16)
					)
					((Said 'kiss')
						(Print 282 17)
					)
					((Said 'embrace')
						(Print 282 18)
					)
				)
			)
		)
	)
)
