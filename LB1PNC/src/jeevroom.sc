;;; Sierra Script 1.0 - (do not remove this comment)
(script# 246) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	jeevroom 0
)
(synonyms
	(butler person fellow)
)

(local
	talkCount
	askCount
	giveCount
	primpCued
	temp7
)
(instance jeevroom of Region
	
	(method (init)
		(super init:)
		(= global195 1024)
		(medicine init: stopUpd:)
		(Load SOUND 76)
		(= theTalker talkJEEVES)
		(Water setPri: 15 init: hide:)
		(switch currentAct
			(1
				(if (or (== global155 17) (== [global368 2] 1))
					(= global194 0)
					(Jeeves
						view: 457
						illegalBits: 0
						posn: 257 145
						setPri: 13
						cycleSpeed: 12
						setCycle: Forward
						init:
					)
				)
			)
			(2
				(if (== global194 0)
					(++ global194)
					(LoadMany VIEW 442 449 456)
					(Jeeves
						view: 458
						illegalBits: 0
						setAvoider: (Avoider new:)
						posn: 189 96
						init:
					)
					(self setScript: hideAway)
				else
					(Jeeves
						view: 442
						setPri: 14
						posn: 94 133
						cel: 4
						ignoreActors: TRUE
						init:
					)
					(JHead
						ignoreActors: TRUE
						setPri: 14
						init:
						setScript: headActions
					)
					(self setScript: sitting)
				)
			)
			(4
				(= theTalker 28)
				(flowers setPri: 14 init:)
				(LoadMany VIEW 454 927)
				(JButt ignoreActors: TRUE setPri: 14 init: stopUpd:)
				(Jeeves
					view: 454
					loop: 0
					cel: 0
					illegalBits: 0
					posn: 43 125
					setPri: 14
					init:
					setScript: Primp
				)
			)
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
						(DoVerb {tell jeeves about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell jeeves about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell jeeves about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell jeeves about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell jeeves about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell jeeves about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell jeeves about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell jeeves about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell jeeves about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell jeeves about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell jeeves about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell jeeves about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell jeeves about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell jeeves about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell jeeves about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell jeeves about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell jeeves about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell jeeves about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell jeeves about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell jeeves about diary})						
					)
					(621 ;crank_
						(DoVerb {tell jeeves about crank})						
					)
					(612 ;cane_
						(DoVerb {tell jeeves about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell jeeves about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell jeeves about handkerchief})
					)
											
						
							(994  ;ear
								(event type: 1 claimed: 1)
								(DoVerb {hear jeeves})
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
								(DoVerb {ask jeeves about gertrude})
							)
							(2
								(DoVerb {tell jeeves about gertrude})
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
							
										
						(998		
							(DoVerb {examine butler})
						)
						(996
							(DoVerb {converse jeeves})	
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
					((Said 'converse/butler')
						(= theTalker talkJEEVES)
						(switch currentAct
							(1
								(switch talkCount
									(0 (Say 1 246 0))
									(1 (Say 1 246 1))
									(else  (Print 246 2))
								)
								(++ talkCount)
							)
							(2
								(switch talkCount
									(0 (Say 1 246 3))
									(1 (Say 1 246 4))
									(2 (Say 1 246 5))
									(else  (Print 246 6))
								)
								(++ talkCount)
							)
							(4
								(= theTalker 28)
								(switch talkCount
									(0 (Say 1 246 7))
									(1 (Say 1 246 8))
									(2 (Say 1 246 9))
									(3 (Say 1 246 10))
									(else  (Print 246 11))
								)
								(++ talkCount)
							)
						)
					)
					((Said 'ask,tell//*<about')
						(if (== currentAct 4)
							(= theTalker 28)
						else
							(= theTalker talkJEEVES)
						)
						(switch askCount
							(0 (Say 1 246 12))
							(1 (Say 1 246 13))
							(2 (Say 1 246 14))
							(3 (Print 246 15))
							(4 (Say 1 246 16))
							(5 (Print 246 17))
							(6
								(if (== currentAct 1)
									(Print 246 18)
								else
									(Print 246 19)
								)
							)
							(7 (Say 1 246 20))
						)
						(if (< askCount 7)
							(++ askCount)
						else
							(= askCount 0)
						)
					)
					((Said 'deliver,hold/*')
						(if (and theInvItem haveInvItem)
							(switch giveCount
								(0 (Print 246 21))
								(1 (Print 246 22))
								(2 (Print 246 23))
								(3 (Print 246 24))
								(else
									(Print 246 25)
								)
							)
							(++ giveCount)
						else
							(DontHave)
						)
					)
					((Said '/butler>')
						(cond 
							((Said 'hear/butler')
								(Print 246 26)
							)
							((Said 'get/butler')
								(Print 246 27)
							)
							((Said 'kill/butler')
								(Print 246 28)
							)
							((Said 'kiss/butler')
								(Print 246 29)
							)
							((Said 'embrace/butler')
								(Print 246 30)
							)
						)
					)
					((Said 'flirt//butler<with')
						(Print 246 31)
					)
					((or (Said 'sleep,lay') (Said 'go/bed,sleep'))
						(if (== currentAct 1)
							(Print 246 32)
						else
							(event claimed: FALSE)
						)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance hideAway of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves cycleSpeed: 1 setCycle: EndLoop self)
			)
			(1
				(Jeeves cycleSpeed: 1 setCycle: BegLoop self)
			)
			(2
				(Jeeves
					view: 456
					loop: 0
					cycleSpeed: 0
					illegalBits: cWHITE
					setCycle: Walk
					setMotion: MoveTo 38 156 self
				)
			)
			(3
				(ego observeControl: cYELLOW)
				(Jeeves
					view: 449
					illegalBits: 0
					posn: 43 127
					loop: 6
					cel: 0
					setScript: Primp
				)
				(JButt setPri: 14 ignoreActors: TRUE init: stopUpd:)
			)
		)
	)
)

(instance Ocab of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego observeControl: cYELLOW)
				(Jeeves loop: 9 cel: 0 setCycle: EndLoop self)
				(JButt hide:)
			)
			(1
				(medicine setPri: 14 setCycle: EndLoop)
				(= seconds 3)
			)
			(2
				(Jeeves setCycle: BegLoop self)
			)
			(3
				(medicine setPri: -1 setCycle: BegLoop self)
				(JButt setPri: 14 show:)
			)
			(4
				(= primpCued 1)
				(client setScript: 0)
			)
		)
	)
)

(instance Primp of Script
	
	(method (doit)
		(super doit:)
		(if primpCued
			(= primpCued FALSE)
			(= cycles 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego observeControl: cYELLOW)
				(Jeeves
					cycleSpeed: 1
					cel: 2
					setPri: 14
					setCycle: EndLoop self
				)
			)
			(1
				(self setScript: Ocab)
			)
			(2
				(Jeeves loop: 1 setCycle: EndLoop self)
			)
			(3
				(Jeeves loop: 2 setCycle: Forward)
				(= seconds 4)
			)
			(4
				(Jeeves loop: 3 cel: 0 setCycle: EndLoop self)
			)
			(5
				(Jeeves loop: 4 setCycle: Forward)
				(= seconds 4)
			)
			(6
				(Jeeves loop: 3 cel: 2 setCycle: BegLoop self)
			)
			(7
				(Jeeves loop: 1 cel: 2 setCycle: BegLoop self)
			)
			(8
				(self setScript: Ocab)
			)
			(9
				(Jeeves loop: 5 cel: 0 setCycle: EndLoop self)
			)
			(10
				(Jeeves loop: 6 cel: 0 setCycle: Forward)
				(= seconds 6)
			)
			(11
				(Jeeves loop: 5 cel: 2 setCycle: BegLoop self)
			)
			(12
				(self setScript: Ocab)
			)
			(13
				(Jeeves loop: 7 cel: 0 setCycle: EndLoop self)
			)
			(14
				(Jeeves loop: 8 cel: 0 setCycle: Forward)
				(Water show: setCycle: Forward)
				(mySound number: 76 loop: -1 play:)
				(= seconds 6)
			)
			(15
				(Water hide:)
				(mySound stop:)
				(Jeeves loop: 7 cel: 2 setCycle: BegLoop self)
			)
			(16
				(if (== currentAct 4)
					(= state 0)
					(= seconds (Random 3 8))
				else
					(= cycles 5)
				)
			)
			(17
				(ego ignoreControl: cYELLOW)
				(Jeeves
					view: 456
					setPri: -1
					setCycle: Walk
					posn: 38 156
					cycleSpeed: 0
					setMotion: MoveTo 94 157 self
				)
				(JButt dispose:)
			)
			(18
				(Jeeves
					view: 442
					cel: 0
					loop: 0
					cycleSpeed: 1
					setCycle: EndLoop self
					ignoreActors: TRUE
				)
			)
			(19
				(Jeeves
					setPri: 14
					loop: 1
					posn: 94 133
					ignoreActors: TRUE
					setScript: sitting
				)
				(JHead
					ignoreActors: TRUE
					setPri: 14
					init:
					setScript: headActions
				)
				(client setScript: 0)
			)
		)
	)
)

(instance sitting of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves loop: 1 cel: 0 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(1
				(Jeeves loop: 2 cel: 0 setCycle: Forward)
				(= seconds (Random 6 12))
			)
			(2
				(Jeeves loop: 1 cel: 3 setCycle: BegLoop)
				(= seconds (Random 6 12))
				(= state -1)
			)
		)
	)
)

(instance headActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(JHead loop: 3 cel: 0 setCycle: EndLoop)
				(= seconds (Random 10 15))
			)
			(1
				(JHead loop: 3 setCycle: BegLoop)
				(= seconds (Random 10 15))
			)
			(2
				(JHead loop: 4 setCycle: EndLoop)
				(= seconds (Random 10 15))
			)
			(3
				(JHead loop: 4 setCycle: BegLoop)
				(= seconds (Random 10 15))
				(= state -1)
			)
		)
	)
)

(instance JHead of Prop
	(properties
		y 128
		x 95
		view 442
		loop 3
	)
)

(instance Jeeves of Actor
	(properties
		y 104
		x 216
		view 458
		loop 2
	)
	
	(method (handleEvent event)
	
		
		(cond 
			((and (== currentAct 1) (Said 'examine[<at]/bed'))
				(Print 246 33)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/butler'))
				(if (== currentAct 4)
					(= theTalker 28)
				else
					(= theTalker talkJEEVES)
				)
				(event claimed: TRUE)
				(if (& global207 $0400)
					(switch currentAct
						(1 (Print 246 33))
						(2 (Print 246 34))
						(4 (Print 246 35))
					)
				else
;;;					(|= global207 $0400)
					(= global207 (| global207 $0400))
					(Say 0 246 36)
				)
			)
		)
	)
)

(instance flowers of Prop
	(properties
		y 143
		x 250
		view 153
		cel 1
		priority 13
	)
	
	(method (handleEvent event)
		
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
		
			(if (ClickedOnObj flowers (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine blossom})
						)
						(995
							(DoVerb {get blossom})
						)
						(else
							(event claimed: FALSE)
						)
										
					)
			)	
		
		
			)
			)
		
		
		
		(cond 
			((Said 'get/blossom')
				(Print 246 37)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/blossom'))
				(event claimed: TRUE)
				(Print 246 38)
			)
		)
	)
)

(instance medicine of Prop
	(properties
		y 131
		x 28
		view 153
		loop 4
	)
	
	(method (handleEvent event)
		
		
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
		
			(if (ClickedOnObj medicine (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine in mirror})
						)
						(995
							(DoVerb {open armoire})
						)
						(else
							(event claimed: FALSE)
						)
										
					)
			)	
		
		
			)
			)
		
		
		
		
		
		
		
		(cond 
			(
				(or
					(Said 'examine<in/mirror')
					(Said 'examine/reflection')
				)
				(if (< (ego distanceTo: medicine) 40)
					(= theTalker talkLAURA)
					(Say 0 246 39)
				else
					(NotClose)
				)
			)
			((Said '(examine<in),open/armoire')
				(Print 246 40)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/armoire,mirror')
				)
				(event claimed: TRUE)
				(Print 246 41)
			)
		)
	)
)

(instance JButt of Prop
	(properties
		y 125
		x 43
		view 454
	)
)

(instance mySound of Sound)

(instance Water of Prop
	(properties
		y 137
		x 40
		view 153
		loop 2
	)
)
