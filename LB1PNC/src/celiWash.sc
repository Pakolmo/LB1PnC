;;; Sierra Script 1.0 - (do not remove this comment)
(script# 229)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	celiWash 0
)
(synonyms
	(celie person girl)
)

(local
	talkCount
	[local1 2]
	gaveBoneToDog
	temp7
)
(instance celiWash of Region ;Region
	
	(method (init)
		(super init:)
		(LoadMany 143 243 228)
		(LoadMany VIEW 480 22 522 901)
		(= global208 2)
		(= [global377 1] 228)
		(Celie illegalBits: 0 init: setScript: wash)
		(ego get: 35) ;dog to inventory.
		(if (== ((inventory at: iSoupBone) owner?) 0)
			(Rover
				view: 522
				loop: 4
				cycleSpeed: 2
				setCycle: Forward
				init:
			)
		else
			(Rover init: setScript: dogActions)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)

		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
		

				(if (and (ClickedOnObj Rover (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						
					

					(605 ;soup_bone_
						(DoVerb {give bone to beauregard})						
					)

							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear beauregard})
							)						
										
							
						(998		
							(DoLook {beauregard})
						)
						(996
							(DoVerb {Talk beauregard})	
						)
							
						(else
						
							(event claimed: FALSE)
						)
					)

				)				
				(if (and (ClickedOnObj Celie (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell celie about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell celie about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell celie about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell celie about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell celie about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell celie about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell celie about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell celie about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell celie about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell celie about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell celie about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell celie about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {ask celie for soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell celie about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell celie about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell celie about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell celie about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell celie about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell celie about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell celie about diary})						
					)
					(621 ;crank_
						(DoVerb {tell celie about crank})						
					)
					(612 ;cane_
						(DoVerb {tell celie about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell celie about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell celie about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear celie})
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
								(DoVerb {ask celie about gertrude})
							)
							(2
								(DoVerb {tell celie about gertrude})
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
								(DoVerb {ask celie about Celie})
							)
							(2
								(DoVerb {tell celie about Celie})
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
								(DoVerb {ask celie about gloria})
							)
							(2
								(DoVerb {tell celie about gloria})
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
								(DoVerb {ask celie about ethel})
							)
							(2
								(DoVerb {tell celie about ethel})
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
								(DoVerb {ask celie about fifi})
							)
							(2
								(DoVerb {tell celie about fifi})
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
								(DoVerb {ask celie about lillian})
							)
							(2
								(DoVerb {tell celie about lillian})
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
								(DoVerb {ask celie about Clarence})
							)
							(2
								(DoVerb {tell celie about clarence})
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
								(DoVerb {ask celie about Wilbur})
							)
							(2
								(DoVerb {tell celie about Wilbur})
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
								(DoVerb {ask celie about rudolph})
							)
							(2
								(DoVerb {tell celie about rudolph})
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
								(DoVerb {ask celie about colonel})
							)
							(2
								(DoVerb {tell celie about colonel})
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
								(DoVerb {ask celie about Jules})
							)
							(2
								(DoVerb {tell celie about Jules})
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
								(DoVerb {ask celie about beauregard})
							)
							(2
								(DoVerb {tell celie about beauregard})
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
								(DoVerb {ask celie about polly})
							)
							(2
								(DoVerb {tell celie about polly})
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
								(DoVerb {ask celie about blaze})
							)
							(2
								(DoVerb {tell celie about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
								
							
						(998		
							(DoLook {celie})
						)
						(996
							(DoVerb {Talk celie})	
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
			(if (== (event type?) saidEvent)
				(cond 
					((Said 'converse/celie')
						(= theTalker talkCELIE)
						(switch talkCount
							(0 (Say 1 229 0))
							(1 (Say 1 229 1))
							(2 (Say 1 229 2))
							(else  (Say 1 229 3))
						)
						(++ talkCount)
					)
					(
						(or
							(Said 'feed,deliver/bone/beauregard')
							(Said 'feed,deliver/beauregard/bone')
						)
						(if (ego has: iSoupBone)
							(if (< (ego distanceTo: Rover) 60)
								(self setScript: giveBone)
							else
								(NotClose)
							)
						else
							(DontHave)
						)
					)
					(
						(or
							(Said 'deliver,feed/*<beauregard')
							(Said 'deliver,feed/*/beauregard')
							(Said 'feed/beauregard')
						)
						(if theInvItem
							(if haveInvItem
								(Print 229 4)
							else
								(DontHave)
							)
						else
							(Print 229 5)
						)
					)
					(
						(or
							(Said 'hold/*/beauregard')
							(Said 'hold/*<beauregard')
						)
						(if (and theInvItem haveInvItem)
							(if (== whichItem iSoupBone)
								(Print 229 6)
							else
								(Print 229 4)
							)
						else
							(DontHave)
						)
					)
					(
						(or
							(Said 'deliver/*/beauregard')
							(Said 'deliver/*<beauregard')
						)
						(if haveInvItem
							(Print 229 4)
						else
							(DontHave)
						)
					)
					((Said '/beauregard>')
						(cond 
							((Said 'get,move')
								(Print 229 7)
							)
							((Said 'pat')
								(if (< (ego distanceTo: Rover) 60)
									(Print 229 8)
									(self setScript: petDog)
								else
									(NotClose)
								)
							)
							((Said 'converse')
								(Print 229 9)
							)
							((Said 'call')
								(Print 229 10)
							)
							((Said 'kill')
								(Print 229 11)
							)
							((Said 'kiss')
								(Print 229 12)
							)
						)
					)
					(
						(or
							(Said 'dry,scrub/dish')
							(Said 'help/celie')
							(Said 'help/dish/scrub<celie')
						)
						(Print 229 13)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance wash of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(Celie loop: 0 setCycle: Forward)
				(= seconds (Random 6 12))
			)
			(1
				(Celie cel: 0 loop: 1 setCycle: EndLoop self)
				(= state
					(switch (Random 1 2)
						(1 -1)
						(2 1)
					))
			)
			(2
				(Celie loop: 0 stopUpd:)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

(instance petDog of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					setAvoider: (Avoider new:)
					setMotion: MoveTo (+ (Rover x?) 26) (+ (Rover y?) 5) self
				)
			)
			(1
				(ego view: 22 loop: 0 setAvoider: 0 setCycle: EndLoop self)
			)
			(2
				(ego loop: 5 cel: 0 setCycle: EndLoop self)
			)
			(3
				(ego loop: 7 setCycle: Forward)
				(= seconds 3)
			)
			(4
				(ego loop: 5)
				(ego cel: (- (NumCels ego) 1) setCycle: BegLoop self)
			)
			(5
				(ego loop: 0)
				(ego cel: (- (NumCels ego) 1) setCycle: BegLoop self)
			)
			(6
				(HandsOn)
				(ego view: 0 loop: 1 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance dogActions of Script
	
	(method (doit)
		(super doit:)
		(cond 
			((not gaveBoneToDog)
				(if (and (< (ego distanceTo: Rover) 30) (== state 0))
					(= cycles 1)
				)
				(if (and (> (ego distanceTo: Rover) 30) (== state 2))
					(= state -1)
					(= cycles 1)
				)
			)
			((< state 3)
				(= state 2)
				(= cycles 1)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Rover
					loop: 0
					cycleSpeed: 2
					cel: (- (NumCels Rover) 1)
					setCycle: BegLoop
				)
			)
			(1
				(Rover loop: 0 cycleSpeed: 2 setCycle: EndLoop self)
			)
			(2
				(Rover loop: 2 cycleSpeed: 2 setCycle: Forward)
			)
			(3
				(Bone dispose:)
				(Rover view: 522 loop: 4 cycleSpeed: 2 setCycle: Forward)
			)
		)
	)
)

(instance giveBone of Script

	(method (doit)
		(super doit:)
		(return
			(if (and (== state 1) (== (ego cel?) 4))
				(ego put: 12 0)
				(Bone init:)
				(++ gaveBoneToDog)
			else
				0
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					setAvoider: (Avoider new:)
					setMotion: MoveTo (+ (Rover x?) 31) (+ (Rover y?) 3) self
				)
			)
			(1
				(ego view: 48 setLoop: 7 cel: 8 setCycle: BegLoop self)
				(Bone cel: 0 posn: (- (ego x?) 13) (- (ego y?) 1))
			)
			(2
				(Print 229 14)
				(ego view: 0 loop: 1)
				(= cycles 1)
			)
			(3
				(ego view: 0 setAvoider: FALSE setLoop: -1 setCycle: Walk)
				(HandsOn)
				(self setScript: 0)
			)
		)
	)
)

(instance Bone of Prop
	(properties
		y 95
		x 97
		view 522
		loop 8
	)
)

(instance Rover of Prop ;Prop
	(properties
		y 90
		x 97
		view 527
	)
	
	(method (handleEvent event)

		
		
		
		
		
		
		
		
		
		
		
		
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/beauregard,dirt')
			)
			(event claimed: TRUE)
			(if (Btst fLookedAtDog)
				(if gaveBoneToDog
					(Print 229 15)
				else
					(Print 229 16)
				)
			else
				(Bset fLookedAtDog)
				(Print 229 17)
			)
		)
	)
)

(instance Celie of Actor
	(properties
		y 103
		x 214
		view 486
	)
	
	(method (handleEvent event)

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0002)))
				(event claimed: TRUE)
				(DoLook {celie})
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event shiftDown) (Said 'examine/celie'))
				)
				(event claimed: TRUE)
				(Print 229 18)
			)
		)
	)
)
