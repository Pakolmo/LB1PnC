;;; Sierra Script 1.0 - (do not remove this comment)
(script# 379)
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
	rudyDrin 0
)
(synonyms
	(drink alcohol)
	(rudolph person fellow)
)

(local
	talkCount
	temp7
)
(instance Rudy of Actor
	(properties
		y 126
		x 169
		view 381
		loop 3
		cel 2
	)
	
	(method (handleEvent event)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0100)))
				(event claimed: TRUE)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event shiftDown) (Said 'examine/rudolph'))
				)
				(event claimed: TRUE)
				(Print 379 0)
			)
		)
	)
)

(instance Jeeves of servent)

(instance rudyDrin of Region
	
	(method (init)
		(super init:)
		(LoadMany 143 243 222)
		(LoadMany VIEW 381 908)
		(= global208 256)
		(= [global377 8] 222)
		(glass setPri: 13 ignoreActors: TRUE init: stopUpd:)
		(Rudy init: setScript: drink)
		(if (not (& global194 $0001))
;;;			(|= global194 $0001)
			(= global194 (| global194 $0001))
			(Jeeves
				view: 444
				posn: -10 101
				setCycle: Walk
				guest1: glass
				exitX: -10
				exitY: 101
				setAvoider: ((Avoider new:) offScreenOK: TRUE)
				init:
			)
			(= global167 1)
		)
	)
	
	(method (doit)
		(super doit:)
		(if (> (ego y?) 158)
			(ego setPri: 14)
		else
			(ego setPri: -1)
		)
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
			




		
			(if (ClickedOnObj Rudy (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor
						
						
					
					(602 ;necklace_
						(DoVerb {tell rudolph about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell rudolph about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell rudolph about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell rudolph about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell rudolph about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell rudolph about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell rudolph about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell rudolph about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell rudolph about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell rudolph about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell rudolph about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell rudolph about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell rudolph about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell rudolph about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell rudolph about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell rudolph about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell rudolph about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell rudolph about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell rudolph about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell rudolph about diary})						
					)
					(621 ;crank_
						(DoVerb {tell rudolph about crank})						
					)
					(612 ;cane_
						(DoVerb {tell rudolph about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell rudolph about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell rudolph about handkerchief})
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
								(DoVerb {ask rudolph about gertie})
							)
							(2
								(DoVerb {tell rudolph about gertie})
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
								(DoVerb {ask rudolph about Celie})
							)
							(2
								(DoVerb {tell rudolph about Celie})
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
								(DoVerb {ask rudolph about gloria})
							)
							(2
								(DoVerb {tell rudolph about gloria})
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
								(DoVerb {ask rudolph about ethel})
							)
							(2
								(DoVerb {tell rudolph about ethel})
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
								(DoVerb {ask rudolph about fifi})
							)
							(2
								(DoVerb {tell rudolph about fifi})
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
								(DoVerb {ask rudolph about lillian})
							)
							(2
								(DoVerb {tell rudolph about lillian})
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
								(DoVerb {ask rudolph about Clarence})
							)
							(2
								(DoVerb {tell rudolph about clarence})
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
								(DoVerb {ask rudolph about Wilbur})
							)
							(2
								(DoVerb {tell rudolph about Wilbur})
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
								(DoVerb {ask rudolph about rudolph})
							)
							(2
								(DoVerb {tell rudolph about rudolph})
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
								(DoVerb {ask rudolph about colonel})
							)
							(2
								(DoVerb {tell rudolph about colonel})
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
								(DoVerb {ask rudolph about Jeeves})
							)
							(2
								(DoVerb {tell rudolph about Jeeves})
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
								(DoVerb {ask rudolph about beauregard})
							)
							(2
								(DoVerb {tell rudolph about beauregard})
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
								(DoVerb {ask rudolph about polly})
							)
							(2
								(DoVerb {tell rudolph about polly})
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
								(DoVerb {ask rudolph about blaze})
							)
							(2
								(DoVerb {tell rudolph about blaze})
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
								(DoVerb {ask rudolph about sarah})
							)
							(2
								(DoVerb {tell rudolph about sarah})
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
								(DoVerb {ask rudolph about crouton})
							)
							(2
								(DoVerb {tell rudolph about crouton})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)														
							
													
						(996
							(DoVerb {converse rudolph})
						)	
						(998
							(cond
								((not (& global207 $0100))
									(event claimed: TRUE)
									(DoLook {rudy})
								)
								(

									(& global207 $0100))
									
								)
											(event claimed: TRUE)
											(Print 379 0)
							
						)
							
						
						(else
							(event claimed: FALSE)
						)
					)
			)
				
	

;;;		
;;;			(if (ClickedOnObj glass (event x?) (event y?)) 
;;;				(event claimed: TRUE)
;;;					(switch theCursor	
;;;						(998			
;;;							(DoVerb {examine glass})
;;;						)
;;;						(995
;;;							(DoVerb {get glass})
;;;						)
;;;						(else
;;;							(event claimed: FALSE)
;;;						)
;;;					)
;;;			)
;;;			
			
			)
			
	)
						
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(if (event claimed?)
			(return (event claimed?))
		)
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'examine/glass,drink')
						(Print 379 1)
					)
					((Said 'hear/rudolph')
						(Print 379 2)
					)
					((Said 'get/drink,glass')
						(Print 379 3)
					)
					((Said 'drink/drink')
						(Print 379 4)
					)
					((Said 'converse/rudolph')
						(= theTalker talkRUDY)
						(switch talkCount
							(0 (Say 1 379 5))
							(1 (Say 1 379 6))
							(2 (Say 1 379 7))
							(else  (Print 379 8))
						)
						(++ talkCount)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance drink of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Rudy
					cycleSpeed: 2
					setPri: 14
					illegalBits: 0
					ignoreActors: TRUE
					setCycle: BegLoop self
				)
			)
			(1
				(glass hide:)
				(Rudy loop: 2 cel: 3 setCycle: BegLoop self)
			)
			(2
				(Rudy loop: 1 cel: 0 setCycle: EndLoop)
				(= seconds 3)
			)
			(3 (Rudy setCycle: BegLoop self))
			(4
				(Rudy loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(5
				(glass show:)
				(Rudy loop: 3 cel: 0 setCycle: EndLoop)
				(if (> (Random 1 100) 30)
					(= state -1)
				)
				(= seconds (Random 6 12))
			)
			(6
				(Rudy loop: 5 cel: 0 setCycle: EndLoop)
				(if (< (Random 1 100) 50)
					(= state 8)
				)
				(= seconds (Random 3 6))
			)
			(7
				(Rudy loop: 6 cel: 0 setCycle: EndLoop)
				(= seconds (Random 3 6))
			)
			(8
				(Rudy loop: 6 setCycle: BegLoop self)
			)
			(9
				(Rudy cel: 3 loop: 5 setCycle: BegLoop self)
			)
			(10
				(if (< (Random 1 100) 70)
					(= state -1)
				else
					(= state 5)
				)
				(= seconds (Random 3 9))
			)
		)
	)
)

(instance glass of Prop
	(properties
		y 138
		x 151
		view 381
		cel 2
	)
		(method (handleEvent event) ;add NOOO
	
				(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
			



		
			(if (ClickedOnObj glass (event x?) (event y?)) 
				(event claimed: TRUE)
					(switch theCursor	
						(998			
							(DoVerb {examine glass})
						)
						(995
							(DoVerb {get glass})
						)
						(else
							(event claimed: FALSE)
						)
					)
			)
			
			)
				)
	
	
)
)