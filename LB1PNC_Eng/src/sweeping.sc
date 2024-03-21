;;; Sierra Script 1.0 - (do not remove this comment)
(script# 269)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sweeping 0
)
(synonyms
	(butler person fellow)
)

(local
	toXY = [136 141 69 147 139 141]
	local6
	talkCount
	toldEgo
	temp7
)
(instance sweeping of Region
	
	(method (init)
		(super init:)
		(DisposeScript SAVE)
		(= global195 1024)
		(LoadMany VIEW 459 910)
		(Jeeves
			view: 447
			setCycle: Walk
			posn: 330 150
			init:
			setScript: sweepFeather
		)
		(Feather setPri: 8 ignoreActors: TRUE init:)
	)
	
	(method (doit)
		(if (Jeeves isBlocked:)
			(if (not toldEgo)
				(= toldEgo TRUE)
				(Print 269 0)
			)
		else
			(= toldEgo FALSE)
		)
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
				
		
			
				(if (ClickedOnObj Jeeves (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Jeeves about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Jeeves about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Jeeves about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Jeeves about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Jeeves about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Jeeves about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Jeeves about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Jeeves about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Jeeves about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Jeeves about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Jeeves about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Jeeves about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Jeeves about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Jeeves about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Jeeves about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Jeeves about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Jeeves about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Jeeves about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Jeeves about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Jeeves about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Jeeves about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Jeeves about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Jeeves about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Jeeves about handkerchief})
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
								(DoVerb {ask jeeves about gertie})
							)
							(2
								(DoVerb {tell jeeves about gertie})
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
								(DoVerb {ask jeeves about Celie})
							)
							(2
								(DoVerb {tell jeeves about Celie})
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
								(DoVerb {ask jeeves about gloria})
							)
							(2
								(DoVerb {tell jeeves about gloria})
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
								(DoVerb {ask jeeves about ethel})
							)
							(2
								(DoVerb {tell jeeves about ethel})
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
								(DoVerb {ask jeeves about fifi})
							)
							(2
								(DoVerb {tell jeeves about fifi})
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
								(DoVerb {ask jeeves about lillian})
							)
							(2
								(DoVerb {tell jeeves about lillian})
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
								(DoVerb {ask jeeves about Clarence})
							)
							(2
								(DoVerb {tell jeeves about clarence})
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
								(DoVerb {ask jeeves about Wilbur})
							)
							(2
								(DoVerb {tell jeeves about Wilbur})
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
								(DoVerb {ask jeeves about rudolph})
							)
							(2
								(DoVerb {tell jeeves about rudolph})
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
								(DoVerb {ask jeeves about colonel})
							)
							(2
								(DoVerb {tell jeeves about colonel})
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
								(DoVerb {ask jeeves about Jeeves})
							)
							(2
								(DoVerb {tell jeeves about Jeeves})
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
								(DoVerb {ask jeeves about beauregard})
							)
							(2
								(DoVerb {tell jeeves about beauregard})
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
								(DoVerb {ask jeeves about polly})
							)
							(2
								(DoVerb {tell jeeves about polly})
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
								(DoVerb {ask jeeves about blaze})
							)
							(2
								(DoVerb {tell jeeves about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
																				
						(996 ;talk
							(DoVerb {converse Jeeves})
						)
						(994
								(DoVerb {hear Jeeves})
						)	
						(998
								(DoVerb {look Jeeves})
						)
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
	
	
						(if (ClickedOnObj Feather (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
					
					(998
						(DoVerb {look feather})
					)
					(995
						(DoVerb {get feather})
					)
					(else				
						(event claimed: FALSE)
								)
							)
						
						)
	
		
			)
						)
		
		
		
		
		
		
		
		
		
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance sweepFeather of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Jeeves setMotion: MoveTo 250 151 self)
				(= gDoor 1)
			)
			(2
;;;				(|= global141 $0002)
				(= global141 (| global141 $0002))
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: EndLoop self)
			)
			(3
				(Jeeves loop: 3 setCycle: Forward)
				(Feather dispose:)
				(= seconds 4)
			)
			(4
				(Jeeves cel: 2 loop: 1 setCycle: BegLoop self)
			)
			(5
				(Jeeves
					view: 447
					setCycle: Walk
					setMotion:
						MoveTo
						[toXY (* local6 2)]
						[toXY (+ (* local6 2) 1)]
						self
				)
			)
			(6
				(Jeeves view: 459 cel: 0 loop: 0 setCycle: EndLoop self)
			)
			(7
				(Jeeves loop: 2 setCycle: Forward)
				(= seconds 4)
			)
			(8
				(Jeeves cel: 2 loop: 0 setCycle: BegLoop self)
			)
			(9
				(Jeeves view: 447 setCycle: Walk ignoreActors: FALSE)
				(if (< local6 2)
					(++ local6)
					(= state 4)
				)
				(= cycles 1)
			)
			(10
				(Jeeves setMotion: MoveTo 330 150 self)
			)
			(11
				(= gDoor 0)
				(Jeeves setScript: 0 dispose:)
			)
		)
	)
)

(instance Jeeves of Actor
	(properties
		y 140
		x 196
	)
	
	(method (handleEvent event)
		(cond 
			(
				(and
					(not (& global207 $0400))
					(or (MousedOn self event shiftDown) (Said 'examine/butler'))
				)
				(= theTalker talkJEEVES)
;;;				(|= global207 $0400)
				(= global207 (| global207 $0400))				
				(event claimed: TRUE)
				(Say 0 269 1)
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event shiftDown) (Said 'examine/butler'))
				)
				(event claimed: TRUE)
				(Print 269 2)
			)
			((Said 'ask,tell//*<about')
				(= theTalker talkJEEVES)
				(switch (Random 1 7)
					(1 (Say 1 269 3))
					(2 (Say 1 269 4))
					(3 (Print 269 5))
					(4 (Say 1 269 6))
					(5 (Say 1 269 7))
					(6 (Print 269 8))
					(else  (Say 1 269 9))
				)
			)
			((Said 'deliver,hold/*')
				(if (and theInvItem haveInvItem)
					(switch (Random 1 5)
						(1 (Print 269 10))
						(2 (Print 269 11))
						(3 (Print 269 12))
						(4 (Print 269 13))
						(else  (Print 269 14))
					)
				else
					(DontHave)
				)
			)
			((Said '/butler>')
				(cond 
					((Said 'converse')
						(= theTalker talkJEEVES)
						(switch talkCount
							(0 (Say 1 269 15))
							(1 (Say 1 269 16))
							(2 (Say 1 269 17))
							(else  (Print 269 18))
						)
						(++ talkCount)
					)
					((Said 'hear')
						(Print 269 19)
					)
					((Said 'get')
						(Print 269 20)
					)
					((Said 'kill')
						(Print 269 21)
					)
					((Said 'kiss')
						(Print 269 22)
					)
					((Said 'embrace')
						(Print 269 23)
					)
					((Said 'flirt')
						(Print 269 24)
					)
				)
			)
		)
	)
)

(instance Feather of Prop
	(properties
		y 151
		x 227
		view 132
		loop 5
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/feather')
				(Print 269 25)
			)
			((or (Said 'examine/feather') (MousedOn self event shiftDown))
				(Print 269 26)
				(event claimed: TRUE)
			)
		)
	)
)
