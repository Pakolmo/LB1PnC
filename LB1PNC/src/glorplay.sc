;;; Sierra Script 1.0 - (do not remove this comment)
(script# 233)
(include game.sh)
(use Main)
(use servent)
(use atsgl)
(use Intrface)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	glorplay 0
)
(synonyms
	(actress person girl)
)

(local
	local0
	local1 = [220 221 225 226]
;;;	[local1 5] = [220 221 225 226]
	temp7
)
(instance Jeeves of servent)

(instance glorplay of Region ;Region

	(method (init)
		(super init:)
		(LoadMany SOUND 99 220 221 225 226)
		(LoadMany 143 243)
		(if (== currentAct 2)
			(if (not (& global118 $0008))
				(LoadMany FONT 41)
				(LoadMany SOUND 29 94 95 96)
				(Load VIEW 642)
				(Load SCRIPT 406)
			)
			(Load VIEW 902)
			(LoadMany 143 258)
			(= [global377 2] 258)
			(= global199 2)
		)
		(= global208 4)
		(if (not (& global145 $0002))
			(Load SCRIPT AVOIDER)
		)
		(Gloria
			view: 370
			loop: 0
			illegalBits: 0
			posn: 293 94
			stopUpd:
		)
		(Arm setPri: 6 init:)
		(Ash setPri: 6 init:)
		(Head setPri: 6 init:)
		(Smoke setPri: 6 init:)
		(self setScript: Smoking)
		(Gloria init:)
		(Leg init: setScript: crossLeg)
		(record init: setScript: playRecord)
		(if (and (== currentAct 0) (not (& global194 $0004)))
;;;			(|= global194 $0004)
			(= global194 (| global194 $0004))
			(Jeeves
				view: 444
				posn: 320 98
				setCycle: Walk
				guest1: Gloria
				exitX: 320
				exitY: 98
				itemX: 295
				itemY: 100
				setAvoider: ((Avoider new:) offScreenOK: TRUE)
				init:
			)
			(= global167 1)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(if (< global159 3)
			(++ global159)
		else
			(= global159 0)
		)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed?) (return))
		(DisposeScript SAVE)


						(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)	
				(if (ClickedOnObj Gloria (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Gloria about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Gloria about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Gloria about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Gloria about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Gloria about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Gloria about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Gloria about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Gloria about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Gloria about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Gloria about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Gloria about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Gloria about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Gloria about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Gloria about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Gloria about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Gloria about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Gloria about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Gloria about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Gloria about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Gloria about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Gloria about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Gloria about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Gloria about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Gloria about handkerchief})
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
								(DoVerb {ask gloria about gertrude})
							)
							(2
								(DoVerb {tell gloria about gertrude})
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
								(DoVerb {ask gloria about Celie})
							)
							(2
								(DoVerb {tell gloria about Celie})
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
								(DoVerb {ask gloria about gloria})
							)
							(2
								(DoVerb {tell gloria about gloria})
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
								(DoVerb {ask gloria about ethel})
							)
							(2
								(DoVerb {tell gloria about ethel})
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
								(DoVerb {ask gloria about fifi})
							)
							(2
								(DoVerb {tell gloria about fifi})
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
								(DoVerb {ask gloria about lillian})
							)
							(2
								(DoVerb {tell gloria about lillian})
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
								(DoVerb {ask gloria about Clarence})
							)
							(2
								(DoVerb {tell gloria about clarence})
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
								(DoVerb {ask gloria about Wilbur})
							)
							(2
								(DoVerb {tell gloria about Wilbur})
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
								(DoVerb {ask gloria about rudolph})
							)
							(2
								(DoVerb {tell gloria about rudolph})
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
								(DoVerb {ask gloria about colonel})
							)
							(2
								(DoVerb {tell gloria about colonel})
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
								(DoVerb {ask gloria about Jules})
							)
							(2
								(DoVerb {tell gloria about Jules})
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
								(DoVerb {ask gloria about beauregard})
							)
							(2
								(DoVerb {tell gloria about beauregard})
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
								(DoVerb {ask gloria about polly})
							)
							(2
								(DoVerb {tell gloria about polly})
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
								(DoVerb {ask gloria about blaze})
							)
							(2
								(DoVerb {tell gloria about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
																								
						(996 ;talk
							(DoVerb {converse Gloria})
						)
						(994
								(DoVerb {hear Gloria})
						)
						(998	
							
							(= temp7
								(PrintSpecial
;;;									{Gloria}
;;;									#button {Examine} 1
;;;									#button {Examine cigar} 2
;;;									#button {Examine boa} 3
;;;		
									{Gloria}
									#button {Mirar} 1
									#button {Mirar cigarro} 2								
									#button {Mirar boa} 3	
								)
							)
							(switch temp7
								(1 	
									(DoLook {gloria})
								)
								(2
									(DoVerb {examine cigar}) 
								)
								(3
									(DoVerb {examine boa}) 
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








		(if (== (event type?) saidEvent)
			(cond 
				(
					(or
						(Said 'play,attach,change/music,record[/(gramophone,(player<record))<on]')
						(Said '(rotate<on,off),(wind<up)/gramophone,(player<record)')
					)
					(if haveInvItem
						(Print 233 0)
					else
						(Print 233 1)
					)
				)
				((Said '/boa>')
					(cond 
						((Said 'examine')
							(Print 233 2)
						)
						((Said 'get')
							(Print 233 3)
						)
					)
				)
				((Said '/cigarette>')
					(cond 
						((Said 'examine')
							(Print 233 4)
						)
						((Said 'smoke')
							(Print 233 5)
						)
						((Said 'get')
							(Print 233 6)
						)
					)
				)
				((and (<= currentAct 1) (Said 'deliver,hold/*'))
					(if (and theInvItem haveInvItem)
						(Print 233 7)
					else
						(DontHave)
					)
				)
			)
		)
	)
)

(instance Smoking of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== currentAct 2)
					(cond 
						((not global216)
							(= state -1)
						)
						((not (& global118 $0008))
;;;							(|= global118 $0008)
							(= global118 (| global118 $0008))							
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?)
							(= state -1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(Arm cycleSpeed: 1 loop: 1 cel: 0 setCycle: EndLoop)
				(= seconds 3)
			)
			(2
				(Arm setCycle: BegLoop self)
			)
			(3
				(Smoke setCycle: EndLoop)
				(if (< (Random 1 100) 30)
					(= state 6)
				)
				(= seconds (Random 6 12))
			)
			(4
				(Arm loop: 2 setCycle: EndLoop self)
			)
			(5
				(Arm loop: 3 setCycle: Forward)
				(if (!= (Gloria script?) goSee)
					(Ash show: setCycle: EndLoop self)
				)
			)
			(6
				(Ash hide:)
				(Arm loop: 2 cel: 2 setCycle: BegLoop)
				(= seconds (Random 6 12))
				(= state 0)
			)
			(7
				(Head setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(8
				(Head setCycle: BegLoop)
				(= seconds (Random 6 12))
				(= state 0)
			)
		)
	)
)

(instance goSee of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(HandsOff)
				(if (ego inRect: 43 113 100 125)
					(ego
						setMotion: MoveTo (+ (ego x?) 20) (+ (ego y?) 20)
					)
				)
				(Gloria
					view: 360
					setCycle: Walk
					setAvoider: (Avoider new:)
					setMotion: MoveTo 72 118 self
				)
				(Leg hide:)
				(Arm hide:)
				(Head hide:)
				(Ash hide:)
				(Smoke hide:)
			)
			(1
				(gDoor setCycle: EndLoop self)
				(gMySound setCycle: EndLoop)
			)
			(2
				(Gloria illegalBits: 0 setMotion: MoveTo 35 118 self)
			)
			(3
				(gDoor setCycle: BegLoop)
				(gMySound setCycle: BegLoop self)
			)
			(4
				(= seconds 5)
			)
			(5
				(gDoor setCycle: EndLoop self)
				(gMySound setCycle: EndLoop)
			)
			(6
				(if (ego inRect: 271 84 320 98)
					(ego setMotion: MoveTo 268 104)
				)
				(Gloria setMotion: MoveTo 72 118 self)
			)
			(7
				(cls)
				(gDoor setCycle: BegLoop self)
				(gMySound setCycle: BegLoop)
			)
			(8
				(= theTalker talkGLORIA)
				(Say 1 233 8)
				(gDoor stopUpd:)
				(gMySound stopUpd:)
				(Gloria setMotion: MoveTo 293 94 self)
			)
			(9
				(Gloria view: 370 loop: 0 setAvoider: 0)
				(DisposeScript AVOIDER)
				(Arm show:)
				(Head show:)
				(Leg show:)
				(Ash show:)
				(Smoke show:)
				(HandsOn)
				(client setScript: Smoking)
			)
		)
	)
)

(instance crossLeg of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Leg setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(1
				(Leg setCycle: BegLoop)
				(= seconds (Random 12 18))
				(= state -1)
			)
		)
	)
)

(instance Gloria of Actor
	(properties
		y 134
		x 187
		view 369
	)
	
	(method (handleEvent event &tmp temp0)
		
						(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)	
				(if (ClickedOnObj Gloria (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Gloria about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Gloria about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Gloria about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Gloria about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Gloria about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Gloria about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Gloria about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Gloria about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Gloria about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Gloria about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Gloria about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Gloria about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Gloria about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Gloria about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Gloria about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Gloria about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Gloria about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Gloria about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Gloria about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Gloria about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Gloria about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Gloria about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Gloria about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Gloria about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask actress about Rudolph}) ;fixed
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about Jules})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Gloria about blaze})
							)															
						(996 ;talk
							(DoVerb {converse Gloria})
						)
						(994
								(DoVerb {hear Gloria})
						)
						(998	
							
							(= temp7
								(PrintSpecial
									{Gloria}
									#button {Examine} 1
									#button {Examine cigar} 2
									#button {Examine boa} 3
		
									{Gloria}
									#button {Mirar} 1
									#button {Mirar cigarro} 2								
									#button {Mirar boa} 3	
								)
							)
							(switch temp7
								(1 	
									(DoLook {actress})
								)
								(2
									(DoVerb {examine cigar}) 
								)
								(3
									(DoVerb {examine boa}) 
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
		
		
		
		
		
		
		
		
		
				
		
		
		(= theTalker talkGLORIA)
		(cond 
			(
				(and
					(Btst fSawDeadGuest)
					(Said 'tell[/actress]/(death<gertie),gertie<about')
				)
				(if (& deadGuests deadGERTRUDE)
					(if (& global145 $0002)
						(= temp0
							(switch currentAct
								(2 50)
								(else  43)
							))
						(= global212 2)
						(= global209 event)
						(proc243_1 temp0 233 9)
					else
						(DisposeScript SAVE)
;;;						(|= global145 $0002)
						(= global145 (| global145 $0002))
						(Say 1 233 10)
						(Gloria setScript: goSee)
					)
				else
					(Say 1 233 11)
				)
			)
			((and (<= currentAct 1) (Said 'ask,tell//*<about'))
				(Print 233 7)
			)
			((and (<= currentAct 1) (Said 'deliver,hold'))
				(if (and theInvItem haveInvItem)
					(Print 233 7)
				else
					(DontHave)
				)
				(event claimed: TRUE)
			)
			(
				(and
					(not (& global207 $0004))
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/actress[/!*]')
					)
				)
				(event claimed: TRUE)
;;;				(|= global207 $0004)
				(= global207 (| global207 $0004))
				(Say 0 233 12)
			)
			(
				(and
					(& global207 $0004)
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/actress[/!*]')
					)
				)
				(event claimed: TRUE)
				(if (== currentAct 2)
					(Print 233 13)
				else
					(Print 233 14)
				)
			)
			((Said '/actress>')
				(cond 
					((Said 'hear')
						(Print 233 15)
					)
					((Said 'converse')
						(if (== currentAct 2)
							(switch global172
								(0 (Say 1 233 16))
								(1 (Say 1 233 17))
								(2 (Say 1 233 18))
								(else  (Print 233 19))
							)
							(++ global172)
						else
							(Print 233 7)
						)
					)
					((Said 'get')
						(Print 233 20)
					)
					((Said 'kill')
						(Print 233 21)
					)
					((Said 'kiss')
						(Print 233 22)
					)
					((Said 'embrace')
						(Print 233 23)
					)
				)
			)
		)
	)
)

(instance Arm of Prop
	(properties
		y 56
		x 289
		view 370
		loop 1
	)
)

(instance Smoke of Prop
	(properties
		y 54
		x 292
		view 370
		loop 6
	)
)

(instance Ash of Prop
	(properties
		y 89
		x 274
		view 370
		loop 7
	)
)

(instance Head of Prop
	(properties
		y 56
		x 294
		view 370
		loop 4
	)
)

(instance Leg of Prop
	(properties
		y 94
		x 293
		view 370
		loop 8
	)
)

(instance recordMusic of Sound)

(instance record of Prop
	(properties
		y 67
		x 98
		view 136
		loop 5
		priority 6
		signal fixPriOn
	)
)

(instance playRecord of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(record setCycle: Forward)
				(recordMusic
					number: [local1 global159]
					loop: 1
					play: self
				)
			)
			(1
				(recordMusic number: 99 loop: -1 play:)
				(if (< global159 3)
					(++ global159)
				else
					(= global159 0)
				)
				(if (== global199 2)
					(= state -1)
				)
				(= cycles 50)
			)
			(2
				(record setCycle: 0)
				(recordMusic stop:)
				(client setScript: 0)
			)
		)
	)
)
