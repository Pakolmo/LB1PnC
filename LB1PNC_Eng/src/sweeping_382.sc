;;; Sierra Script 1.0 - (do not remove this comment)
(script# 382)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
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
	local0
	talkCount
	temp7
)
(instance sweeping of Region

	(method (init)
		(super init:)
		(= global195 1024)
		(LoadMany VIEW 459 910)
		(Jeeves view: 447)
		(boa setPri: 1 ignoreActors: TRUE init:)
		(if (== ((inventory at: iBrokenRecord) owner?) 36)
			(Load VIEW 17)
			(bRecord setPri: 1 ignoreActors: 1 init:)
			(footprint setPri: 1 ignoreActors: 1 init:)
		)
		(Jeeves illegalBits: -32752 x: 340 y: 100)
		(self setScript: rm36Actions)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
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
								(DoVerb {ask Jeeves about gertie})
							)
							(2
								(DoVerb {tell Jeeves about gertie})
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
								(DoVerb {ask Jeeves about Celie})
							)
							(2
								(DoVerb {tell Jeeves about Celie})
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
								(DoVerb {ask Jeeves about gloria})
							)
							(2
								(DoVerb {tell Jeeves about gloria})
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
								(DoVerb {ask Jeeves about ethel})
							)
							(2
								(DoVerb {tell Jeeves about ethel})
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
								(DoVerb {ask Jeeves about fifi})
							)
							(2
								(DoVerb {tell Jeeves about fifi})
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
								(DoVerb {ask Jeeves about lillian})
							)
							(2
								(DoVerb {tell Jeeves about lillian})
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
								(DoVerb {ask Jeeves about Clarence})
							)
							(2
								(DoVerb {tell Jeeves about clarence})
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
								(DoVerb {ask Jeeves about Wilbur})
							)
							(2
								(DoVerb {tell Jeeves about Wilbur})
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
								(DoVerb {ask Jeeves about rudolph})
							)
							(2
								(DoVerb {tell Jeeves about rudolph})
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
								(DoVerb {ask Jeeves about colonel})
							)
							(2
								(DoVerb {tell Jeeves about colonel})
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
								(DoVerb {ask Jeeves about Jeeves})
							)
							(2
								(DoVerb {tell Jeeves about Jeeves})
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
								(DoVerb {ask Jeeves about beauregard})
							)
							(2
								(DoVerb {tell Jeeves about beauregard})
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
								(DoVerb {ask Jeeves about polly})
							)
							(2
								(DoVerb {tell Jeeves about polly})
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
								(DoVerb {ask Jeeves about blaze})
							)
							(2
								(DoVerb {tell Jeeves about blaze})
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
								(DoVerb {ask Jeeves about sarah})
							)
							(2
								(DoVerb {tell Jeeves about sarah})
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
								(DoVerb {ask Jeeves about crouton})
							)
							(2
								(DoVerb {tell Jeeves about crouton})
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
	
				(if (ClickedOnObj bRecord (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
						(995
								(DoVerb {get record})
						)	
						(998
								(DoVerb {look record})
						)
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
		
				(if (ClickedOnObj boa (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
						(995
								(DoVerb {get boa})
						)	
						(998
								(DoVerb {look feather})
						)
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
				
				(if (ClickedOnObj footprint (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
						(604
							(DoVerb {examine mud with monocle})
						)
						(995
								(DoVerb {get mud})
						)	
						(998
								(DoVerb {examine mud})
						)
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
				
		
				
			)
		)
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(return
			(if
				(and
					(== (event type?) saidEvent)
					(Said 'examine/mud,spot,bootprint')
				)
				(Print 382 0)
			else
				FALSE
			)
		)
	)
)

(instance rm36Actions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 30))
			(1
				(= gMySound 1)
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: 0
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					init:
				)
				(Jeeves setMotion: MoveTo 153 110 self)
			)
			(2
				(Jeeves setMotion: MoveTo 132 100 self)
			)
			(3
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: EndLoop self)
			)
			(4
				(Jeeves setLoop: 3 setCycle: Forward)
				(boa dispose:)
;;;				(|= global141 $0004)
				(= global141 (| global141 $0004))
				(if (cast contains: bRecord)
					(bRecord dispose:)
				)
				(= seconds 4)
			)
			(5
				(Jeeves cel: 2 loop: 1 setCycle: BegLoop self)
			)
			(6
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: FALSE
					setLoop: -1
					setMotion: MoveTo 117 106 self
				)
			)
			(7
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: EndLoop self)
			)
			(8
				(Jeeves setLoop: 3 setCycle: Forward)
				(footprint dispose:)
				(= seconds 3)
			)
			(9
				(Jeeves cel: 2 loop: 1 setCycle: BegLoop self)
			)
			(10
				(Jeeves view: 447 setCycle: Walk ignoreActors: FALSE)
				(Jeeves setLoop: -1 setMotion: MoveTo 340 98 self)
			)
			(11
				(Jeeves dispose:)
				(= gMySound 0)
				(DisposeScript AVOIDER)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face ego bRecord)
				(= cycles 2)
			)
			(1
				(ego view: 17 cel: 0 setMotion: 0 setCycle: EndLoop self)
			)
			(2
				(ego get: 9)
				(bRecord hide:)
				(= gotItem TRUE)
				(Print 382 1)
				(= cycles 2)
			)
			(3
				(ego setCycle: BegLoop self)
			)
			(4
				(HandsOn)
				(ego view: 0 setCycle: Walk)
				(client dispose: setScript: 0)
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
				(Say 0 382 2)
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event shiftDown) (Said 'examine/butler'))
				)
				(event claimed: TRUE)
				(Print 382 3)
			)
			((Said 'ask,tell//*<about')
				(= theTalker talkJEEVES)
				(switch (Random 1 7)
					(1 (Say 1 382 4))
					(2 (Say 1 382 5))
					(3 (Print 382 6))
					(4 (Say 1 382 7))
					(5 (Say 1 382 8))
					(6 (Print 382 9))
					(else  (Say 1 382 10))
				)
			)
			((Said 'deliver,hold/*')
				(if (and theInvItem haveInvItem)
					(switch (Random 1 5)
						(1 (Print 382 11))
						(2 (Print 382 12))
						(3 (Print 382 13))
						(4 (Print 382 14))
						(else  (Print 382 15))
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
							(0 (Say 1 382 16))
							(1 (Say 1 382 17))
							(2 (Say 1 382 18))
							(else  (Print 382 19))
						)
						(++ talkCount)
					)
					((Said 'hear') (Print 382 20))
					((Said 'get') (Print 382 21))
					((Said 'kill') (Print 382 22))
					((Said 'kiss') (Print 382 23))
					((Said 'embrace') (Print 382 24))
				)
			)
			((Said 'flirt//butler<with') (Print 382 25))
		)
	)
)

(instance bRecord of Prop
	(properties
		y 96
		x 115
		view 136
		loop 2
		cel 7
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((or (MousedOn self event shiftDown) (Said 'examine/record'))
				(Print 382 26)
				(event claimed: TRUE)
			)
			((Said 'get/record[<broken]')
				(if (< (ego distanceTo: bRecord) 15)
					(self setScript: pickUp)
				else
					(NotClose)
				)
			)
		)
	)
)

(instance boa of Prop
	(properties
		y 100
		x 90
		view 136
		loop 9
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/feather'))
				(Print 382 27)
				(event claimed: TRUE)
			)
			((Said 'get/feather')
				(Print 382 28)
			)
		)
	)
)

(instance footprint of Prop
	(properties
		y 106
		x 100
		view 136
		loop 3
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/mud')
				(Print 382 29)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/mud,spot,bootprint')
				)
				(Print 382 30)
				(event claimed: TRUE)
			)
		)
	)
)
