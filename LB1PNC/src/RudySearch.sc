;;; Sierra Script 1.0 - (do not remove this comment)
(script# 385) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	RudySearch 0
)
(synonyms
	(rudolph person fellow)
)

(local
	[local0 6] = [246 158 76 150 192 112]
	local6
	talkCount
	askCount
	temp7
)
(instance Rudy of Actor
	(properties
		y 146
		x 173
		view 380
	)
	
	(method (handleEvent event)
		
			
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
								(DoVerb {ask rudolph about gertrude})
							)
							(2
								(DoVerb {tell rudolph about gertrude})
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
						
						
						
						(996
							(DoVerb {converse rudolph})
						)	
						(998
							(cond
								((not (& global207 $0100)) 
									(event claimed: TRUE)
;;;									(|= global207 $0100)
									(= global207 (| global207 $0100))
									(Say 0 385 0)
							)
							(
								
									(& global207 $0100)
									
								
								(event claimed: TRUE)
								(Print 385 1)
							)			
							)
						)
						(else
							(event claimed: FALSE)
						)
					)
			)
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		(cond 
			((and (not (& global207 $0100)) (MousedOn self event shiftDown))
				(event claimed: TRUE)
;;;				(|= global207 $0100)
				(= global207 (| global207 $0100))				
				(Say 0 385 0)
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event shiftDown) (Said 'examine/rudolph'))
				)
				(event claimed: TRUE)
				(Print 385 1)
			)
			((Said 'ask,tell//*<about')
				(= theTalker talkRUDY)
				(switch askCount
					(0
						(Say 1 385 2)
						(++ askCount)
					)
					(1
						(Print 385 3)
					)
				)
			)
			((Said 'hold,deliver/*')
				(if (and theInvItem haveInvItem)
					(Print 385 3)
				else
					(DontHave)
				)
			)
			((Said '/rudolph>')
				(cond 
					((Said 'converse')
						(= theTalker talkRUDY)
						(switch talkCount
							(0
								(Say 1 385 4)
							)
							(1
								(Say 1 385 5)
							)
							(else
								(Print 385 6)
							)
						)
						(++ talkCount)
					)
					((Said 'get')
						(Print 385 7)
					)
					((Said 'kill')
						(Print 385 8)
					)
					((Said 'kiss,embrace')
						(Print 385 9)
					)
				)
			)
			((Said 'flirt//rudolph<with')
				(Print 385 10)
			)
		)
	)
)

(instance RudySearch of Region

	(method (init)
		(super init:)
		(= global195 256)
		(Load VIEW 393)
		(self setScript: searching)
		(Rudy
			setAvoider: ((Avoider new:) offScreenOK: TRUE)
			illegalBits: cWHITE
			init:
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed?) (return))
	)
)

(instance searching of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0004))
;;;						(|= global118 $0004)
						(= global118 (| global118 $0004))
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
				(Rudy
					view: 380
					cycleSpeed: 0
					setCycle: Walk
					setMotion:
						MoveTo
						[local0 (* local6 2)]
						[local0 (+ (* local6 2) 1)]
						self
				)
			)
			(2
				(Rudy view: 393 cel: 0 cycleSpeed: 1 setCycle: EndLoop self)
			)
			(3 (= seconds 3))
			(4
				(Rudy setCycle: BegLoop self)
				(if (< local6 2)
					(++ local6)
					(= state -1)
				)
			)
			(5
				(Rudy
					view: 380
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo -20 152 self
				)
			)
			(6
				(Rudy dispose:)
				(client setScript: 0)
			)
		)
	)
)
