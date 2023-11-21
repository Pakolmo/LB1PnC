;;; Sierra Script 1.0 - (do not remove this comment)
(script# 378) ;OK
(include game.sh)
(use Main)
(use servent)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ClarSit 0
)
(synonyms
	(attorney person fellow)
)

(local
	local0
	[local1 2]
	roomCycles
	temp7
)
(instance Jeeves of servent)

(instance ClarSit of Region
	
	(method (init)
		(super init:)
		(LoadMany 143 243 218)
		(LoadMany 142 7)
		(= global208 64)
		(= [global377 6] 218)
		(ClarAss init: stopUpd:)
		(Clarence setPri: 6 init: setScript: clarActions)
		(Smoke setPri: 6 init: hide:)
		(if (not (& global194 $0002))
;;;			(|= global194 $0002)
			(= global194 (| global194 $0002))
			(Jeeves
				view: 444
				posn: -15 98
				setCycle: Walk
				guest1: ClarAss
				exitX: -10
				exitY: 98
				itemX: 178
				itemY: 108
				setAvoider: ((Avoider new:) offScreenOK: TRUE)
				init:
			)
		)
	)
	
	(method (doit)
		(if (< roomCycles 50)
			(++ roomCycles)
		else
			(= global167 1)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 204)
		(DisposeScript CHASE)
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
								(DoVerb {ask Clarence about gertrude})
							)
							(2
								(DoVerb {tell Clarence about gertrude})
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
								(DoVerb {ask Clarence about Jules})
							)
							(2
								(DoVerb {tell Clarence about Jules})
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
;;;								#button {Examine} 1
;;;								#button {Examine cigar} 2
								#button {Examinar} 1
								#button {Cigarro} 2
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
	
	
	
	)
	)
		
		
		
		
		
		
		
		
		
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '/attorney')
								(if (& global207 $0040)
									(Print 378 0)
								else
									(event claimed: FALSE)
								)
							)
							((Said '/cigar')
								(Bset fExaminedCigar)
								(Print 378 1)
							)
							((Said '/drink,glass')
								(Print 378 2)
							)
						)
					)
					((Said 'converse>')
						(if (Said '/attorney')
							(Print 378 3)
						)
					)
					((Said 'hear/attorney')
						(Print 378 4)
					)
					((Said 'get/butt')
						(Print 378 5)
					)
					((Said 'get/drink,glass')
						(Print 378 6)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance clarActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Clarence loop: 5 cel: 0 setCycle: EndLoop self)
			)
			(1
				(Clarence loop: 4 cel: 0 cycleSpeed: 1 setCycle: EndLoop self)
			)
			(2
				(Smoke cel: 0 setCycle: EndLoop self show:)
				(if (< local0 1)
					(++ local0)
					(= state 0)
				else
					(= local0 0)
				)
			)
			(3
				(Smoke cel: 0 hide:)
				(Clarence loop: 1 cel: 5 cycleSpeed: 2 setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(4
				(Clarence loop: 2 cel: 0 setCycle: EndLoop)
				(= seconds (Random 6 12))
				(= state -1)
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
		(cond 
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
				(Print 378 0)
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
