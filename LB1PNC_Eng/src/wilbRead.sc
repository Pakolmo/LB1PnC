;;; Sierra Script 1.0 - (do not remove this comment)
(script# 220)
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
	wilbRead 0
)
(synonyms
	(c person fellow)
)

(local
	wilburTalkCount
	local1
	temp7
)
(procedure (WilburPrint)
	(Gloria stopUpd:)
	(Wilbur loop: 2 setCycle: Forward)
	(Print &rest
		#at 80 15
		#font 4
		#width 125
		#mode teJustCenter
		#dispose
	)
)

(procedure (GloriaPrint)
	(Wilbur stopUpd:)
	(Gloria setCycle: Forward)
	(Print &rest
		#at 160 15
		#font 4
		#width 125
		#mode teJustCenter
		#dispose
	)
)

(instance Jeeves of servent)

(instance wilbRead of Region
	
	(method (init)
		(super init:)
		(LoadMany FONT 4 41)
		(LoadMany VIEW 642 907)
		(LoadMany SOUND 29 94 95 96)
		(LoadMany 143 243 219 406)
		(= global208 128)
		(= [global377 7] 219)
		(Wilbur init: stopUpd: setScript: reading)
		(cond 
			((and (> [global368 2] 1) (== global199 1))
				(= [global368 2] 0)
				(Load VIEW 361)
				(if (== prevRoomNum 33)
					(ego posn: (ego x?) 145)
					(Gloria posn: 290 151)
				)
				(Gloria init: setScript: wilbGlor)
				(= global199 2)
			)
			((not (& global194 $0008))
;;;				(|= global194 $0008)
				(= global194 (| global194 $0008))
				(Jeeves
					view: 444
					posn: 320 150
					setCycle: Walk
					guest1: Wilbur
					exitX: 340
					exitY: 150
					itemX: 197
					itemY: 149
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					init:
				)
				(= global167 1)
			)
		)
		(ego observeBlocks: WilburBlock)
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
						
					(if (or (ClickedOnObj Wilbur (event x?) (event y?))
						(ClickedInRect 138 142 196 204 event))
						
						
						
					
					(event claimed: TRUE)
					(switch theCursor	
					(998
						(if (not (& global207 $0080))
						(DoVerb {examine c})						
						)
						(if (& global207 $0080)
							(event claimed: TRUE)
							(Print 220 17)
							(DoVerb {examine magazine})
						)
					)
					(996
						(DoVerb {converse wilbur})
					)
					(994
						(DoVerb {hear wilbur})
					)
											
					
					(602 ;necklace_
						(DoVerb {tell wilbur about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell wilbur about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell wilbur about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell wilbur about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell wilbur about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell wilbur about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell wilbur about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell wilbur about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell wilbur about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell wilbur about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell wilbur about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell wilbur about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell wilbur about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell wilbur about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell wilbur about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell wilbur about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell wilbur about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell wilbur about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell wilbur about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell wilbur about diary})						
					)
					(621 ;crank_
						(DoVerb {tell wilbur about crank})						
					)
					(612 ;cane_
						(DoVerb {tell wilbur about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell wilbur about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell wilbur about handkerchief})
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
								(DoVerb {ask wilbur about gertie})
							)
							(2
								(DoVerb {tell wilbur about gertie})
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
								(DoVerb {ask wilbur about Celie})
							)
							(2
								(DoVerb {tell wilbur about Celie})
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
								(DoVerb {ask wilbur about gloria})
							)
							(2
								(DoVerb {tell wilbur about gloria})
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
								(DoVerb {ask wilbur about ethel})
							)
							(2
								(DoVerb {tell wilbur about ethel})
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
								(DoVerb {ask wilbur about fifi})
							)
							(2
								(DoVerb {tell wilbur about fifi})
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
								(DoVerb {ask wilbur about lillian})
							)
							(2
								(DoVerb {tell wilbur about lillian})
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
								(DoVerb {ask wilbur about Clarence})
							)
							(2
								(DoVerb {tell wilbur about clarence})
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
								(DoVerb {ask wilbur about Wilbur})
							)
							(2
								(DoVerb {tell wilbur about Wilbur})
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
								(DoVerb {ask wilbur about rudolph})
							)
							(2
								(DoVerb {tell wilbur about rudolph})
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
								(DoVerb {ask wilbur about colonel})
							)
							(2
								(DoVerb {tell wilbur about colonel})
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
								(DoVerb {ask wilbur about Jeeves})
							)
							(2
								(DoVerb {tell wilbur about Jeeves})
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
								(DoVerb {ask wilbur about beauregard})
							)
							(2
								(DoVerb {tell wilbur about beauregard})
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
								(DoVerb {ask wilbur about polly})
							)
							(2
								(DoVerb {tell wilbur about polly})
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
								(DoVerb {ask wilbur about blaze})
							)
							(2
								(DoVerb {tell wilbur about blaze})
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
								(DoVerb {ask wilbur about sarah})
							)
							(2
								(DoVerb {tell wilbur about sarah})
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
								(DoVerb {ask wilbur about crouton})
							)
							(2
								(DoVerb {tell wilbur about crouton})
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
		
		

		
		
		
		
		
		
		
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(cond 
					((Said '/c>')
						(cond 
							((Said 'hear')
								(Print 220 0)
							)
							((Said 'converse')
								(= theTalker talkWILBUR)
								(switch wilburTalkCount
									(0
										(Say 1 220 1)
										(= theTalker talkLAURA)
										(Say 0 220 2)
									)
									(1
										(Say 1 220 3)
										(= theTalker talkLAURA)
										(Say 0 220 4)
									)
									(2
										(Say 1 220 5)
										(= theTalker talkLAURA)
										(Say 0 220 6)
									)
									(3
										(Print 220 7)
									)
									(else
										(Print 220 8)
									)
								)
								(++ wilburTalkCount)
							)
						)
					)
					((Said '/magazine>')
						(cond 
							((Said 'get,rob')
								(Print 220 9)
							)
							((Said 'examine,read')
								(if (< (ego distanceTo: Wilbur) 20)
									(Bset fExaminedMagazine)
									(Print 220 10)
								else
;;;									(Print 220 11)
								)
							)
						)
					)
				)
			else
				FALSE
			)
		)
	)
)

(instance reading of Script

	(method (changeState newState &tmp rand)
		(switch (= state newState)
			(0
				(Wilbur loop: (if local1 5 else 0) setCycle: EndLoop self)
			)
			(1
				(= rand (Random 1 100))
				(cond 
					(local1
						(cond 
							((< rand 43)
								(= state 2)
							)
							((> rand 56)
								(= state 5)
							)
							(else
								(= state -1)
							)
						)
					)
					((< rand 51)
						(= state -1)
					)
				)
				(= seconds (Random 5 10))
			)
			(2
				(= local1 1)
				(Wilbur loop: 4 cel: 0 setCycle: EndLoop)
				(= seconds (Random 5 10))
				(= state 0)
			)
			(3
				(Wilbur loop: 6 cel: 0 setCycle: EndLoop self)
			)
			(4
				(Wilbur loop: 7 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(5
				(Wilbur loop: 6 cel: 3 setCycle: BegLoop self)
				(= state 0)
			)
			(6
				(= local1 0)
				(Wilbur loop: 4 cel: 4 setCycle: EndLoop self)
				(= state 0)
			)
		)
	)
)

(instance wilbGlor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Bset 24)
				(Gloria setCycle: Walk setMotion: MoveTo 218 142 self)
			)
			(1
				(Wilbur loop: 1 cel: 0 setCycle: EndLoop)
				(Gloria view: 361 loop: 2)
				(GloriaPrint 220 12)
				(= seconds 5) ;7
			)
			(2
				(cls)
				(WilburPrint 220 13)
				(= seconds 5) ;7
			)
			(3
				(cls)
				(GloriaPrint 220 14)
				(= seconds 5); 7
			)
			(4
				(cls)
				(WilburPrint 220 15)
				(= seconds 3) ;5
			)
			(5
				(cls)
				(GloriaPrint 220 16)
				(= seconds 2)
			)
			(6
				(cls)
				(Gloria view: 360 setMotion: MoveTo 340 152 self)
				(Wilbur loop: 1 cel: 1 setCycle: BegLoop)
			)
			(7
				(HandsOn)
				(Wilbur setScript: reading)
				(Gloria dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance Wilbur of Actor
	(properties
		y 142
		x 196
		view 424
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0080)))
				(event claimed: TRUE)
				(DoLook {wilbur})
			)
			(
				(and
					(& global207 $0080)
					(or (MousedOn self event shiftDown) (Said 'examine/c'))
				)
				(event claimed: TRUE)
				(Print 220 17)
			)
		)
	)
)

(instance WilburBlock of Block
	(properties
		top 138
		left 196
		bottom 142
		right 204
	)
)

(instance Gloria of Actor
	(properties
		y 150
		x 310
		view 360
		loop 1
	)
)
