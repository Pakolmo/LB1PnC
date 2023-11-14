;;; Sierra Script 1.0 - (do not remove this comment)
(script# 270) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	cololill 0
)
(synonyms
	(colonel fellow)
	(lil girl)
)

(local
	local0
	colTalkCount
	lillTalkCount
	local3
	colLillTalkCount
	argueCount
	temp7
)
(procedure (ColPrint)
	(Colonel cycleSpeed: 1 setCycle: Forward)
	(Print &rest
		#at 15 10
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(procedure (LillPrint)
	(Lillian loop: 1 setCycle: Forward)
	(LHead loop: 7 setCycle: Forward)
	(Print &rest
		#at 140 10
		#font 4
		#width 125
		#mode teJustCenter
		#draw
		#dispose
	)
)

(instance cololill of Region

	(method (init)
		(super init:)
		(Load FONT 4)
		(Load VIEW 909)
		(LoadMany 143 243 298)
		(= global208 512)
		(= [global377 9] 298)
		(if (== [global368 1] 0)
			(= [global368 1] 1800)
		)
		(Colonel init: stopUpd:)
		(smoke1
			view: 304
			loop: 2
			cel: 0
			x: 182
			y: 97
			z: 30
			init:
			hide:
		)
		(smoke2
			view: 304
			loop: 3
			cel: 0
			posn: (+ (Colonel x?) 11) (- (Colonel y?) 24)
			setPri: (CoordPri (Colonel y?))
			init:
			hide:
		)
		(Glow
			posn: (+ (Colonel x?) 10) (Colonel y?)
			z: 29
			init:
			hide:
		)
		(if (and (== [global368 1] 1) (& global118 $0002))
			(= global195 512)
			(Colonel setScript: colonelActions)
		else
			(Load FONT 41)
			(Load VIEW 642 905)
			(LoadMany SOUND 29 94 95 96)
			(LoadMany 143 406 372)
			(= global208 544)
			(= [global377 5] 372)
			(LHead init:)
			(Lillian init:)
			(Bset fSawLillianColonelTogether)
			(self setScript: argue)
		)
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
						(if (ClickedOnObj Colonel (event x?) (event y?)) 

					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Colonel about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Colonel about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Colonel about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Colonel about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Colonel about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Colonel about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Colonel about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Colonel about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Colonel about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Colonel about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Colonel about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Colonel about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Colonel about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Colonel about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Colonel about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Colonel about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Colonel about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Colonel about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Colonel about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Colonel about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Colonel about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Colonel about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Colonel about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Colonel about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about Jules})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Colonel about blaze})
							)															
						(996 ;talk
							(DoVerb {converse Colonel})
						)
						(998	
							(DoVerb {Examine Colonel})
						)
						(995
							(= temp7
												(Print
													{Colonel}
													#button {Mover} 1
													#button {Mirar Cigarro} 2								
													#button {Coger Cigarro} 3
													#button {Oler Cigarro} 3
												)
											)
											(switch temp7
												(1 
													(DoVerb {move wheelchair})
												)
												(2 
													(DoVerb {examine butt})
												)		
												(3 
													(DoVerb {get butt})
												)		
												(4 
													(DoVerb {smell butt})
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
													
							
							
							
							
														
						(996 ;talk
							(DoVerb {converse lillian})
						)
						(998	
							(DoVerb {Examine lillian})
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
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'hear/fifi,colonel')
					(if (cast contains: Lillian)
						(Print 270 0)
					else
						(Print 270 1)
					)
				)
				((cast contains: Lillian))
				((Said 'converse,ask,tell')
					(if colLillTalkCount
						(Print 270 2)
					else
						(= theTalker 10)
						(Say 1 270 3)
						(++ colLillTalkCount)
					)
				)
				((Said 'deliver/*')
					(if haveInvItem
						(Print 270 4)
					else
						(DontHave)
					)
				)
				((Said 'hold/*]')
					(if haveInvItem
						(Print 270 5)
					else
						(DontHave)
					)
				)
			)
		)
	)
)

(instance argue of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216)
						(= state -1)
					)
					((not (& global118 $0002))
						(|= global118 $0002)
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
				(User canInput: FALSE)
				(if (== (= argueCount (& gCurRoomNum_2 $7fff)) gCurRoomNum_2)
					(if (< gCurRoomNum_2 10)
						(++ gCurRoomNum_2)
					else
						(= gCurRoomNum_2 -32767)
					)
				else
					(switch argueCount
						(1 (= gCurRoomNum_2 -32766))
						(2 (= gCurRoomNum_2 -32763))
						(5 (= gCurRoomNum_2 -32762))
						(6 (= gCurRoomNum_2 -32760))
						(8 (= gCurRoomNum_2 -32752))
						(10 (= gCurRoomNum_2 -32767))
					)
				)
				(switch argueCount
					(0 (LillPrint 270 6))
					(1 (LillPrint 270 7))
					(2 (ColPrint 270 8))
					(3 (ColPrint 270 9))
					(4 (LillPrint 270 10))
					(5 (ColPrint 270 11))
					(6 (LillPrint 270 12))
					(7 (ColPrint 270 13))
					(8 (ColPrint 270 14))
					(9 (LillPrint 270 15))
					(10 (LillPrint 270 16))
				)
				(= seconds 5)
			)
			(2
				(LHead setCycle: 0)
				(cls)
				(Lillian setCycle: 0)
				(Colonel setCycle: 0)
				(= seconds 3)
				(switch argueCount
					(0 (LillPrint 270 17))
					(5 (ColPrint 270 18))
					(6 (ColPrint 270 19))
					(8 (LillPrint 270 20))
					(9 (ColPrint 270 21))
					(10 (ColPrint 270 22))
					(else
						(= seconds 1)
					)
				)
			)
			(3
				(cls)
				(LHead setCycle: 0 setScript: headActions)
				(Lillian setCycle: 0 setScript: lillActions)
				(Colonel setScript: colonelActions)
				(User canInput: TRUE)
				(client setScript: 0)
			)
		)
	)
)

(instance colonelActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel
					view: 304
					loop: 0
					cycleSpeed: 1
					cel: 0
					setCycle: EndLoop self
				)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Forward)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: BegLoop self
				)
			)
			(3
				(smoke2 setCycle: Forward show:)
				(smoke1 show: setCycle: EndLoop self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance lillActions of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Lillian cel?) 0)
					(Lillian loop: 0 cel: 3 setCycle: BegLoop self)
				else
					(= cycles 1)
				)
			)
			(1
				(Lillian loop: 0 cel: 0)
				(= seconds (Random 6 15))
			)
			(2
				(Lillian loop: 2 cel: 0 setCycle: EndLoop)
				(= seconds (Random 6 15))
			)
			(3
				(if (and (== (LHead loop?) 5) (== (LHead cel?) 2))
					(Lillian loop: 3 cel: 0 setCycle: EndLoop self)
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(Lillian loop: 4 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(5
				(Lillian loop: 2 cel: 2 setCycle: BegLoop self)
				(= state 0)
			)
		)
	)
)

(instance headActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 12 18)))
			(1
				(LHead loop: 5 cel: 0 setCycle: EndLoop)
				(= seconds (Random 12 18))
			)
			(2
				(LHead setCycle: BegLoop)
				(= seconds (Random 12 18))
			)
			(3
				(LHead loop: 6 cel: 0 setCycle: EndLoop)
				(= seconds (Random 2 8))
			)
			(4
				(LHead setCycle: BegLoop)
				(= seconds (Random 12 18))
				(= state 0)
			)
		)
	)
)

(instance Colonel of Prop
	(properties
		y 97
		x 176
		view 312
	)
	
	(method (handleEvent event)
		

		
		
				
		
		(if (< (ego distanceTo: Colonel) (ego distanceTo: Lillian))
			(= global214 512)
		else
			(= global214 32)
		)
		(if (cast contains: Lillian)
			(cond 
				((Said 'examine/people')
					(Print 270 23)
				)
				((Said 'examine,converse/person')
					(Print 270 24)
				)
				((Said 'converse/people')
					(Print 270 25)
				)
			)
		)
		(cond 
			((Said 'converse/colonel,person')
				(if (cast contains: Lillian)
					(= theTalker talkCOLONEL)
					(switch colTalkCount
						(0 (Say 1 270 26))
						(1 (Say 1 270 27))
						(2 (Say 1 270 28))
						(3 (Say 1 270 29))
						(else
							(Print 270 30)
						)
					)
					(++ colTalkCount)
				else
					(event claimed: FALSE)
				)
			)
			((Said 'examine/butt')
				(Bset fExaminedCigar)
				(Print 270 31)
			)
			((Said 'get/butt')
				(Print 270 32)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/colonel,person')
				)
				(if (& global207 $0200)
					(if (cast contains: Lillian)
						(Print 270 23)
					else
						(Print 270 33)
					)
				else
					(|= global207 $0200)
					(DoLook {colonel})
				)
				(event claimed: TRUE)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		view 304
		loop 2
	)
)

(instance smoke2 of Prop
	(properties
		view 304
		loop 3
	)
)

(instance Lillian of Prop
	(properties
		y 94
		x 221
		view 502
	)
	
	(method (handleEvent event)
		(return
			(cond 
				((and (MousedOn self event shiftDown) (not (& global207 $0020)))
					(event claimed: TRUE)
					(DoLook {lillian})
				)
				(
					(and
						(& global207 $0020)
						(or (MousedOn self event shiftDown) (Said 'examine/lil'))
					)
					(event claimed: TRUE)
					(Print 270 23)
				)
				((Said 'converse/lil')
					(= theTalker talkLILLIAN)
					(switch lillTalkCount
						(0 (Say 1 270 34))
						(1 (Say 1 270 35))
						(2 (Say 1 270 36))
						(3 (Say 1 270 37))
						(else  (Say 1 270 38))
					)
					(++ lillTalkCount)
				)
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 94
		x 221
		z 39
		view 502
		loop 7
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)
