;;; Sierra Script 1.0 - (do not remove this comment)
(script# 24)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room24 0
)
(synonyms
	(attorney person fellow)
)

(local
	local0
	local1
	local2
	temp7
)
(instance Room24 of Room
	(properties
		picture 24
	)
	
	(method (init)
		(= west 23)
		(= east 8)
		(super init:)
		(self setFeatures: Hedge Gazebo)
		(if
			(and
				(>= currentAct 3)
				(not (& deadGuests deadGLORIA))
				(not (& deadGuests deadLILLIAN))
			)
			(if (and (!= gCurRoomNum 23) (!= gCurRoomNum curRoomNum))
				(switch (Random 1 2)
					(1 (= gCurRoomNum curRoomNum))
					(2 (= gCurRoomNum 23))
				)
			)
			(if (and (== currentAct 3) (< global115 7))
				(= gCurRoomNum 24)
			)
			(if (== gCurRoomNum curRoomNum)
				(= local2 1)
				(self setRegions: 263)
			)
		)
		(if
			(and
				(or (== global154 5) (== [global368 1] 1))
				(== currentAct 1)
			)
			(Clarence init: setScript: clarActions)
			(LoadMany 143 243 248)
			(Load VIEW 906)
			(= global208 64)
			(= [global377 6] 248)
		)
		(switch prevRoomNum
			(18 (ego posn: 10 135))
			(8 (ego posn: 315 175 loop: 1))
			(30 (ego posn: 272 188))
			(29 (ego posn: 34 188))
			(23 (ego posn: 10 150))
		)
		(ego view: 0 init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 24 0)
		)
		(switch (ego onControl: 0)
			(cBLUE
				(curRoom newRoom: 18)
			)
			(cRED
				(if (and (not local1) (not local2))
					(= local1 1)
					(User canControl: FALSE)
					(if (< (ego y?) 150)
						(ego setMotion: MoveTo 189 172)
					else
						(ego setMotion: MoveTo 197 126)
					)
				)
			)
			(else 
				(if local1 (= local1 0) (User canControl: 1))
			)
		)
		(if (== (ego edgeHit?) SOUTH)
			(if (< (ego x?) 159)
				(curRoom newRoom: 29)
			else
				(curRoom newRoom: 30)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		
		
	
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					
					(if (ClickedInRect 4 314 183 189 event) ;exit room down
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (ego x?) (+ (ego y?) 215))
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)	
					(if (ClickedInRect 0 5 113 189 event) ;exit room left
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (- (ego x?) 315) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)	
					(if (ClickedInRect 314 319 110 189 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (+ (ego x?) 300) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)			
		
		
		
		
		
					(if (and (ClickedOnObj Clarence (event x?) (event y?)) 
							(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
								
					(602 ;necklace_
						(DoVerb {tell Clarence about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Clarence about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Clarence about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Clarence about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Clarence about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Clarence about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Clarence about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Clarence about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Clarence about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Clarence about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Clarence about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Clarence about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Clarence about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Clarence about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Clarence about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Clarence about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Clarence about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Clarence about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Clarence about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Clarence about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Clarence about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Clarence about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Clarence about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Clarence about handkerchief})
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
								(DoVerb {ask Clarence about gertie})
							)
							(2
								(DoVerb {tell Clarence about gertie})
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
								(DoVerb {ask Clarence about Celie})
							)
							(2
								(DoVerb {tell Clarence about Celie})
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
								(DoVerb {ask Clarence about gloria})
							)
							(2
								(DoVerb {tell Clarence about gloria})
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
								(DoVerb {ask Clarence about ethel})
							)
							(2
								(DoVerb {tell Clarence about ethel})
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
								(DoVerb {ask Clarence about fifi})
							)
							(2
								(DoVerb {tell Clarence about fifi})
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
								(DoVerb {ask Clarence about lillian})
							)
							(2
								(DoVerb {tell Clarence about lillian})
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
								(DoVerb {ask Clarence about Clarence})
							)
							(2
								(DoVerb {tell Clarence about clarence})
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
								(DoVerb {ask Clarence about Wilbur})
							)
							(2
								(DoVerb {tell Clarence about Wilbur})
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
								(DoVerb {ask Clarence about rudolph})
							)
							(2
								(DoVerb {tell Clarence about rudolph})
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
								(DoVerb {ask Clarence about colonel})
							)
							(2
								(DoVerb {tell Clarence about colonel})
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
								(DoVerb {ask Clarence about Jeeves})
							)
							(2
								(DoVerb {tell Clarence about Jeeves})
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
								(DoVerb {ask Clarence about beauregard})
							)
							(2
								(DoVerb {tell Clarence about beauregard})
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
								(DoVerb {ask Clarence about polly})
							)
							(2
								(DoVerb {tell Clarence about polly})
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
								(DoVerb {ask Clarence about blaze})
							)
							(2
								(DoVerb {tell Clarence about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)															
						(996 ;talk
							(DoVerb {converse Clarence})
						)
						(994
								(DoVerb {hear Clarence})
						)	
						(998

							    (DoVerb {examine attorney})
							)
							(else
								(event claimed: FALSE)
							)
										
						)
						)
	
			
		
				(if (ClickedOnObj Hedge (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998		
							(DoVerb {examine bush})
		
						)
						
						(else
							(event claimed: FALSE)
						)
					)
				)
		
		
		
			(if (and (ClickedOnObj Gazebo (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
						(998		
								(= temp7
												(PrintSpecial
;;;													{Gazebo}
;;;													#button {Examine} 1
;;;													#button {Examine in} 2								
;;;													#button {Examine below} 3
													{Cenador}
													#button {Examinar} 1
													#button {Examinar dentro} 2								
													#button {Examinar por debajo} 3

												)
											)
											(switch temp7
												(1 							
													(DoVerb {Examine Gazebo})	
												)
												(2
													(DoVerb {Examine in Gazebo})
												)
												(3
													(DoVerb {Examine below Gazebo})
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
		(if
			(and
				global208
				(Said 'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>')
			)
			(self setScript: (ScriptID 243 0))
			((self script?) handleEvent: event)
			(if (event claimed?) (return (event claimed?)))
		)
		(return
			(if (== (event type?) saidEvent)
				(if
					(and
						global208
						(Said
							'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
						)
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return (event claimed?)))
				)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]') (Print 24 0))
							((Said '/path') (Print 24 1))
							((Said '/stair,stair') (Print 24 2))
							((Said '[<down][/dirt]')
								(if (& (ego onControl: 0) cYELLOW)
									(Print 24 3)
								else
									(event claimed: FALSE)
								)
							)
							((or (Said '/ceiling') (Said '<up'))
								(if (& (ego onControl: 0) cYELLOW)
									(Print 24 4)
								else
									(event claimed: FALSE)
								)
							)
						)
					)
					((Said 'climb/stair')
						(Print 24 5)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance clarActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Clarence loop: 0 cel: 0 cycleSpeed: 1 setCycle: EndLoop)
				(= seconds 4)
			)
			(1
				(Clarence loop: 1 cel: 0 setCycle: EndLoop self)
			)
			(2
				(Clarence setCycle: BegLoop)
				(= seconds (Random 5 10))
			)
			(3
				(Clarence loop: 2 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(4
				(Clarence setCycle: 0)
				(if (< (Random 1 100) 35)
					(= state 0)
				else
					(= state 2)
				)
				(= seconds (Random 5 15))
			)
		)
	)
)

(instance Clarence of Prop
	(properties
		y 167
		x 191
		view 412
		cel 1
	)
	
	(method (handleEvent event &tmp temp0)
		(cond 
			((and (MousedOn self event shiftDown) (not (& global207 $0040)))
				(event claimed: TRUE)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/attorney,attorney')
					)
				)
				(event claimed: TRUE)
				(Print 24 6)
			)
			((Said 'converse/attorney,attorney')
				(= theTalker talkCLARENCE)
				(Say 1 24 7)
			)
		)
	)
)

(instance Hedge of RFeature
	(properties
		nsTop 97
		nsBottom 115
		nsRight 48
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/garden,bush')
			)
			(event claimed: TRUE)
			(Print 24 8)
		)
	)
)

(instance Gazebo of RFeature
	(properties
		nsTop 3
		nsLeft 148
		nsBottom 152
		nsRight 267
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<in/gazebo')
				(Print 24 9)
			)
			((Said 'examine<below/gazebo')
				(Print 24 10)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/gazebo'))
				(event claimed: TRUE)
				(Print 24 11)
			)
		)
	)
)
