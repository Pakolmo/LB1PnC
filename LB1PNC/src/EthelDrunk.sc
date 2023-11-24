;;; Sierra Script 1.0 - (do not remove this comment)
(script# 202)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	EthelDrunk 0
)
(synonyms
	(ethel person girl)
)

(local
	local0 = [160 185 160 132 65 129 242 187 197 172 233 134 189 138 80 138 80 113 136 177 135 163]
	local24 = [0 0 160 132 83 42 340 187 340 170 304 97 159 113 -20 138 -20 138 166 240 118 240]
	toXY = [
		160 240
		-20 156
		-20 62
		-20 187
		104 240
		156 240
		340 139
		340 130
		193 143
		41 113
		340 140
		]
	local72 = [0 14 21 27 26 25 13 9 3 10 4 5]
	local84
	talkCount
	local86
	[local87 5]
	temp7
)
(instance Smashed of Sound)

(instance EthelDrunk of Region
	
	(method (init)
		(super init:)
		(if (not (& global118 $0004))
			(LoadMany FONT 41)
			(LoadMany SOUND 29 94 95 96)
			(Load VIEW 642)
			(Load SCRIPT 406)
		)
		(Load VIEW 903)
		(LoadMany 143 243 275)
		(= [global377 3] 275)
		(if (== [global368 0] 0)
			(= [global368 0] 1099)
			(= global113 0)
		)
		(if (< [global368 0] 2)
			(= [global368 0] 900)
			(= global113 2)
			(= [local24 4] 40)
			(= [local24 5] 240)
		)
		(if (== curRoomNum 25)
			(Ethel setLoop: 0)
		)
		(if
			(and
				(== [local72 (- 11 global113)] curRoomNum)
				(> [global368 0] (* (- 10 global113) 100))
			)
			(Smashed number: 62 loop: -1 priority: 12 play:)
			(= local84 1)
;;;			(|= global208 $0008)
			(= global208 (| global208 $0008))
			(Ethel
				setCycle: Walk
				ignoreHorizon: TRUE
				moveSpeed: 2
				cycleSpeed: 1
				setAvoider: ((Avoider new:) offScreenOK: TRUE)
				posn: [local0 (* global113 2)] [local0 (+ (* global113 2) 1)]
				init:
			)
			(if (== curRoomNum 13)
				(Ethel observeControl: cBROWN)
			)
			(if (== curRoomNum 27)
				(Ethel setMotion: MoveTo 193 143)
			else
				(Ethel
					setMotion:
						MoveTo
						[toXY (* global113 2)]
						[toXY (+ (* global113 2) 1)]
				)
			)
			(= gCurRoomNum_2 curRoomNum)
			(self setScript: ethelActions)
		)
	)
	
	(method (doit)
		(if (and (< [global368 0] 2) (not local84))
			(= [global368 0] 900)
			(= global113 2)
			(= [local24 4] 40)
			(= [local24 5] 240)
		)
		(if
			(and
				(!= curRoomNum 4)
				(== gCurRoomNum_4 0)
				(== (mod [global368 0] 100) 0)
				(== [local72 (/ [global368 0] 100)] curRoomNum)
				(not local84)
			)
			(if (User controls?)
				(Smashed number: 62 loop: -1 priority: 12 play:)
				(DisposeScript SAVE)
				(= global113 (- 11 (/ [global368 0] 100)))
;;;				(|= global208 $0008)
				(= global208 (| global208 $0008))
				(= local84 1)
				(Ethel
					setCycle: Walk
					ignoreHorizon: TRUE
					moveSpeed: 2
					cycleSpeed: 1
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					posn: [local24 (* global113 2)] [local24 (+ (* global113 2) 1)]
					init:
				)
				(Ethel observeControl: cBROWN)
				(if (== curRoomNum 27)
					(Ethel setMotion: MoveTo 193 143)
				else
					(Ethel
						setMotion:
							MoveTo
							[toXY (* global113 2)]
							[toXY (+ (* global113 2) 1)]
					)
				)
				(= gCurRoomNum_2 curRoomNum)
				(self setScript: ethelActions)
			else
				(= [global368 0] (+ [global368 0] 10))
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(if (and (== global113 0) (== curRoomNum 5))
			(= global113 1)
		)
		(if local84
			(if
				(or
					(> (Ethel y?) 200)
					(> (Ethel x?) 320)
					(< (Ethel x?) 0)
				)
				(++ global113)
				(= [global368 0] (- 1100 (* global113 100)))
			else
				(= [global368 0] (- 1120 (* global113 100)))
			)
		)
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
			
				
				(if (ClickedOnObj Ethel (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						
					
					(602 ;necklace_
						(DoVerb {tell ethel about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell ethel about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell ethel about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell ethel about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell ethel about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell ethel about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell ethel about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell ethel about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell ethel about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell ethel about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell ethel about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell ethel about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell ethel about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell ethel about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell ethel about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell ethel about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell ethel about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell ethel about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell ethel about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell ethel about diary})						
					)
					(621 ;crank_
						(DoVerb {tell ethel about crank})						
					)
					(612 ;cane_
						(DoVerb {tell ethel about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell ethel about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell ethel about handkerchief})
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
								(DoVerb {ask ethel about gertie})
							)
							(2
								(DoVerb {tell ethel about gertie})
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
								(DoVerb {ask ethel about Celie})
							)
							(2
								(DoVerb {tell ethel about Celie})
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
								(DoVerb {ask ethel about gloria})
							)
							(2
								(DoVerb {tell ethel about gloria})
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
								(DoVerb {ask ethel about ethel})
							)
							(2
								(DoVerb {tell ethel about ethel})
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
								(DoVerb {ask ethel about fifi})
							)
							(2
								(DoVerb {tell ethel about fifi})
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
								(DoVerb {ask ethel about lillian})
							)
							(2
								(DoVerb {tell ethel about lillian})
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
								(DoVerb {ask ethel about Clarence})
							)
							(2
								(DoVerb {tell ethel about clarence})
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
								(DoVerb {ask ethel about Wilbur})
							)
							(2
								(DoVerb {tell ethel about Wilbur})
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
								(DoVerb {ask ethel about rudolph})
							)
							(2
								(DoVerb {tell ethel about rudolph})
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
								(DoVerb {ask ethel about colonel})
							)
							(2
								(DoVerb {tell ethel about colonel})
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
								(DoVerb {ask ethel about Jeeves})
							)
							(2
								(DoVerb {tell ethel about Jeeves})
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
								(DoVerb {ask ethel about beauregard})
							)
							(2
								(DoVerb {tell ethel about beauregard})
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
								(DoVerb {ask ethel about polly})
							)
							(2
								(DoVerb {tell ethel about polly})
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
								(DoVerb {ask ethel about blaze})
							)
							(2
								(DoVerb {tell ethel about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
						
						(998		
							(DoLook {ethel})
						)
						(996
							(DoVerb {Talk Ethel})	
						)	
						(994
							(DoVerb {hear Ethel})	
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
		(if
			(and
				(== (event type?) saidEvent)
				global208
				(Said 'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>')
			)
			(Ethel setScript: (ScriptID 243 0))
			((Ethel script?) handleEvent: event)
			(if (event claimed?) (return))
		)
	)
)

(instance ethelActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== currentAct 3)
					(cond 
						((not global216)
							(= state -1)
						)
						((not (& global118 $0004))
							(if (and (== gameMinutes 3) (== curRoomNum 10))
								(= local86 1)
								(gDoor startUpd:)
							)
;;;							(|= global118 $0004)
							(= global118 (| global118 $0004))							
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?)
							(= state -1)
						)
					)
				)
				(= cycles 3)
			)
			(1
				(if (and (== curRoomNum 10) local86)
					(= local86 0)
					(gDoor stopUpd:)
				)
				(if
					(and
						(== (Ethel x?) [toXY (* global113 2)])
						(== (Ethel y?) [toXY (+ (* global113 2) 1)])
					)
					(if (== curRoomNum 27) (= state 2))
				else
					(= state 0)
				)
				(= cycles 1)
			)
			(2
				(= local86 0)
				(= local84 0)
				(++ global113)
				(= [global368 0] (- 1100 (* global113 100)))
				(if (< [global368 0] 2)
					(= [global368 0] 900)
					(= global113 2)
				)
				(Smashed fade:)
				(= gCurRoomNum_2 0)
				(Ethel dispose:)
;;;				(&= global208 $fff7)
				(= global208 (& global208 $fff7))
				(= [global377 3] 0)
				(client setScript: 0)
			)
			(3
				(= state 1)
				(Ethel setMotion: MoveTo 110 110 self)
			)
		)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance Ethel of Actor
	(properties
		yStep 3
		view 328
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(= theTalker talkETHEL)
		(return
			(if local84
				(cond 
					((Said '/drink,glass>')
						(cond 
							((Said 'examine')
								(Print 202 0)
							)
							((Said 'get')
								(Print 202 1)
							)
						)
					)
					((Said 'hear/ethel')
						(Print 202 2)
					)
					((and (not (& global207 $0008)) (MousedOn self event shiftDown))
						(event claimed: TRUE)
						(DoLook {ethel})
					)
					(
						(and
							(& global207 $0008)
							(or (MousedOn self event shiftDown) (Said 'examine/ethel'))
						)
						(event claimed: TRUE)
						(Print 202 3)
					)
					((Said 'converse/ethel')
						(= theTalker talkETHEL)
						(switch talkCount
							(0 (Say 1 202 4))
							(1
								(Say 1 202 5)
								(Say 1 202 6)
							)
							(2 (Say 1 202 7))
							(3 (Say 1 202 8))
							(4 (Say 1 202 9))
							(5
								(Say 1 202 10)
								(Say 1 202 11)
							)
							(6 (Say 1 202 12))
							(else  (Print 202 13))
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
