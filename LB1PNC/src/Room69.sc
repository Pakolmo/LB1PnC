;;; Sierra Script 1.0 - (do not remove this comment)
(script# 69)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room69 0
)
(synonyms
	(butler fellow person)
	(room barn)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	temp7
)
(instance Room69 of Room
	(properties
		picture 69
	)
	
	(method (init)
		(super init:)
		(ego get: 37); inventory blaze horse
	
		(addToPics
			add: saddle trough bridle
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures: saddle trough bridle hay1 hay2 window1 window2 window3
		)
		(LoadMany SOUND 40 85 118)
		(LoadMany VIEW 269 63)
		(if (ego has: iCarrot)
			(Load VIEW 8)
		)
		(myMusic number: 40 loop: 1)
		(if (and (not global121) (>= currentAct 2))
			(if (or (== currentAct 6) (== (Random 1 2) 1))
				(= global121 69)
			else
				(= global121 58)
			)
		)
		(if
			(and
				(== global121 69)
				(not (& deadGuests deadWILBUR))
				(not (& deadGuests deadLILLIAN))
			)
			(self setRegions: cGREY)
		)
		(Door init: ignoreActors: TRUE stopUpd:)
		(if (== ((inventory at: iLantern) owner?) 69)
			(Lamp init: stopUpd:)
		)
		(if
			(and
				(== currentAct 1)
				(or (== global155 6) (== global155 7))
			)
			(Jeeves init:)
			(HandsOff)
			(self setScript: feedNag)
		else
			(HandsOn)
		)
		(Horse setPri: 9 init: stopUpd:)
		(Ears setPri: 9 init:)
		(Leg setPri: 9 init: stopUpd:)
		(Tail setPri: 9 init: stopUpd:)
		(Head setPri: 9 init: stopUpd:)
		(ego view: 0 posn: 211 170 illegalBits: -32752 init:)
		(if (== currentAct 1)
			(Load VIEW 440)
			(Load VIEW 445)
			(Load VIEW 452)
			(Hay init:)
		)
	)
	
	(method (doit &tmp temp0)
		(if (FirstEntry)
			(Print 69 0)
		)
		(if (and local0 (& (ego onControl: origin) cBLACK) (not script))
			(Room69 setScript: myDoor)
		)
		(if (and (== [global368 2] 1100) (== currentAct 1))
			(if (not script)
				(= local4 1)
				(HandsOff)
				(self setScript: feedNag)
			else
				(= [global368 2] 1110)
			)
		)
		(if (not local1)
			(cond 
				((== (= temp0 (Random 1 25)) 1)
					(cond 
						((== (Ears cel?) 0)
							(Ears setCycle: EndLoop)
						)
						((== (Ears cel?) (- (NumCels Ears) 1))
							(Ears setCycle: BegLoop)
						)
					)
				)
				((and howFast (> temp0 2) (< temp0 6))
					(cond 
						((== (Tail cel?) 0)
							(Tail setCycle: EndLoop)
						)
						((== (Tail cel?) (- (NumCels Tail) 1))
							(Tail setCycle: BegLoop)
						)
					)
				)
				((and howFast (> temp0 5) (< temp0 8))
					(cond 
						((== (Leg cel?) 0)
							(Leg setCycle: EndLoop)
						)
						((== (Leg cel?) (- (NumCels Leg) 1))
							(Leg setCycle: BegLoop)
						)
					)
				)
			)
		)
		(if (and (not local1) (not local3))
			(= local3 (Random 30 80))
			(myMusic number: 40 loop: 1 play:)
		)
		(-- local3)
		(if (& (ego onControl: FALSE) cBLUE)
			(HandsOff)
			(curRoom newRoom: 13)
		)
		(if
			(and
				(< (ego distanceTo: Horse) 65)
				(> (ego y?) 140)
				(!= ((inventory at: iCarrot) owner?) 69)
				(== local0 1)
				(== local1 0)
			)
			(= local1 1)
			(self setScript: kicked)
		)
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
				(if (ClickedOnPicView saddle (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(995
						(DoVerb {attach saddle}) 
						)
						(998
							(DoVerb {examine saddle}) 
						)
						(else
							(event claimed: FALSE)
						)
				
					)
					
				)							
				(if (ClickedOnPicView trough (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine water}) 
						)
						(else
							(event claimed: FALSE)
						)
					)
				)							
						
				(if (ClickedOnPicView bridle (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {detach bit}) 
						)
						(998
							(DoVerb {examine bit}) 
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)							
				(if (ClickedOnObj Door (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(995
										(= temp7
												(Print
;;;													{Door}
;;;													#button {Enter} 1
;;;													#button {Open} 2	
;;;													#button {Close} 3	


													{Puerta}
													#button {Entrar} 1
													#button {Abrir} 2								
													#button {Cerrar} 3
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {enter room})
												)
												(2	
													(DoVerb {open room})							
												)
												(3
													(DoVerb {close room})							
												)												
												(else
														(event claimed: FALSE)
												)
											)
						
									
						)
						(998
							(DoVerb {examine room}) 
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)											
				(if (ClickedOnObj Lamp (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(612 ;cane
							(DoVerb {get lantern cane})
						)
						(995
							(DoVerb {get ignite}) 
						)
						(998
							(DoVerb {examine ignite}) 
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)			
							
				(if (or (ClickedOnObj Horse (event x?) (event y?)) 
						(ClickedOnObj Head (event x?) (event y?)) 
						(ClickedOnObj Mouth (event x?) (event y?)) 
						(ClickedOnObj Tail (event x?) (event y?)) )

						
						
					(event claimed: TRUE)
					(switch theCursor	

					(602 ;necklace_
						(DoVerb {tell Blaze about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Blaze about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Blaze about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Blaze about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Blaze about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Blaze about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Blaze about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Blaze about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Blaze about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Blaze about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Blaze about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Blaze about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Blaze about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Blaze about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Blaze about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Blaze about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Blaze about matches})						
					)

					(619 ;brass_key_
						(DoVerb {tell Blaze about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Blaze about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Blaze about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Blaze about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Blaze about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Blaze about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about gertie})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask actress about Rudolph}) ;fixed
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about Jeeves})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Blaze about blaze})
							)															
						(994
								(DoVerb {hear blaze})
						)						
						(615 ;Kakarot
							(DoVerb {deliver carrot})
						)
						(995							
							(= temp7
												(PrintSpecial
;;;													{Blaze}

;;;													#button {Mount} 1	
;;;													#button {Move} 2
;;;													#button {Kill} 3
;;;													#button {Pat} 4
													{Blaze}
													#button {Montar} 1
													#button {Mover} 2								
													#button {Matar} 3
													#button {Acariciar} 4
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {mount blaze})
												)
												(2
													(DoVerb {move blaze})
												)
												(3
													(DoVerb {kill blaze})
												)
												(4
													(DoVerb {pat blaze})
												)
												(else
														(event claimed: FALSE)
												)
											)
						)
						(996
														(= temp7
												(PrintSpecial
;;;													{Blaze}

;;;													#button {Converse} 1	
;;;													#button {Bit} 2
;;;													#button {Call} 3
;;;													#button {Kiss} 4
													{Blaze}
													#button {Conversar} 1
													#button {Morder} 2								
													#button {Llamar} 3
													#button {Besar} 4
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {converse blaze})
												)
												(2
													(DoVerb {bit blaze})
												)
												(3
													(DoVerb {call blaze})
												)
												(4
													(DoVerb {kiss blaze})
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
				
				(if (ClickedOnObj Jeeves (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	

					(602 ;necklace_
						(DoVerb {tell butler about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell butler about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell butler about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell butler about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell butler about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell butler about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell butler about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell butler about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell butler about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell butler about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell butler about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell butler about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell butler about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell butler about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell butler about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell butler about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell butler about matches})						
					)

					(619 ;brass_key_
						(DoVerb {tell butler about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell butler about diary})						
					)
					(621 ;crank_
						(DoVerb {tell butler about crank})						
					)
					(612 ;cane_
						(DoVerb {tell butler about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell butler about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell butler about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about gertie})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask actress about Rudolph}) ;fixed
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about Jeeves})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask butler about blaze})
							)															
						(996 ;talk
							(DoVerb {converse butler})
						)
						(994
								(DoVerb {hear butler})
						)				
				(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnObj hay1 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor					
					(996
						(DoVerb {get drink})
					)
					(995
							(= temp7
												(PrintSpecial
;;;													{ }
;;;													#button {Get bale} 1
;;;													#button {Get water} 2	
													{Cama}
													#button {Coger heno} 1
													#button {Coger agua} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {get bale})
												)
												(2
													(DoVerb {get water})
												)
												(else
														(event claimed: FALSE)
												)
										
											)
											
										
					)
					(998
													(= temp7
												(PrintSpecial
;;;													{ }
;;;													#button {Examine in water} 1
;;;													#button {Examine in bale} 2
;;;													#button {Examine bale} 3		
													{ }
													#button {Mirar en agua} 1
													#button {Mirar en heno} 2								
													#button {Mirar heno} 3													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine in water})
												)
												(2
													(DoVerb {examine in bale})
												)
												(3
													(DoVerb {examine bale})
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
			(if (ClickedOnObj hay2 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor					
					(998
						(event claimed: TRUE)
						(Print 69 46)
					)
					(else
							(event claimed: FALSE)
						)
					)
				)
				(if (or (ClickedOnObj window1 (event x?) (event y?)) 		
						(ClickedOnObj window2 (event x?) (event y?)) 		
						(ClickedOnObj window3 (event x?) (event y?)) )
					(event claimed: TRUE)
					(switch theCursor
					(998
						(event claimed: TRUE)
						(Print 69 47)
					)
					(995
								
							(switch (Random 0 1)
									(0 (DoVerb {open window}))
									(1 (DoVerb {break window})
								
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
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]')
								(Print 69 0)
							)
							((Said '/door')
								(Print 69 1)
							)
							((Said '/room')
								(if (== ((inventory at: iLantern) owner?) 69)
									(Print 69 2)
								else
									(Print 69 3)
								)
							)
							((or (Said '/dirt,dirt') (Said '<down'))
								(Print 69 4)
							)
							((Said '/wall')
								(if (== ((inventory at: iLantern) owner?) 69)
									(Print 69 5)
								else
									(Print 69 6)
								)
							)
							((or (Said '/ceiling') (Said '<up'))
								(Print 69 7)
							)
						)
					)
					((Said 'feel,get/lantern/cane')
						(if (ego has: iCane)
							(Print 69 8)
						else
							(DontHave)
						)
					)
					((Said 'climb/wall,room')
						(Print 69 9)
					)
					((Said 'open/window')
						(Print 69 10)
					)
					((Said 'break/window')
						(Print 69 11)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(if (cast contains: Jeeves)
			(= [global368 2] 1050)
			(= global155 7)
		)
		(super newRoom: n)
	)
)

(instance feedHorse of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					setAvoider: (Avoider new:)
					setMotion: MoveTo 150 138 self
				)
			)
			(1
				(Face ego Horse)
				(ego
					view: 8
					cel: 0
					loop: 0
					setAvoider: 0
					setCycle: EndLoop self
				)
			)
			(2
				(Print 69 12)
				(ego cel: 0 loop: 1 setCycle: EndLoop self)
			)
			(3
				(ego cel: 0 loop: 2 setCycle: EndLoop self)
				(Mouth setPri: 9 cycleSpeed: 3 setCycle: Forward init:)
			)
			(4
				(ego put: iCarrot 69)
				(theGame setCursor: 999 (HaveMouse)) ;clear inv cursor, switch to walk	
				(= itemIcon 601)	
				(ego view: 0 loop: 1 setCycle: Walk)
				(HandsOn)
				(= seconds 5)
			)
			(5
				(Mouth dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					ignoreActors: FALSE
					setAvoider: (Avoider new:)
					setMotion: MoveTo 140 142 self
				)
			)
			(1
				(Face ego Horse)
				(if (== local0 0)
					(= local0 1)
					(Door setPri: 13 cycleSpeed: 3 setCycle: EndLoop self)
					(ego ignoreControl: cRED observeControl: cMAGENTA)
				else
					(= local0 0)
					(Door setPri: 10 cycleSpeed: 3 setCycle: BegLoop self)
					(ego ignoreControl: cMAGENTA observeControl: cRED)
				)
			)
			(2
				(ego setAvoider: 0)
				(Door stopUpd:)
				(Horse signal: ignrAct) ;fixed laura movement walk.
				(if (!= ((inventory at: iCarrot) owner?) 69)
					(Room69 setScript: kicked)
				else
					(HandsOn)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance kicked of Script

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== local2 0) (== (Horse cel?) 4))
			(= local2 1)
			(ego
				view: 269
				setLoop: 1
				cel: 0
				illegalBits: 0
				cycleSpeed: 1
				setCycle: EndLoop
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: MoveTo 130 142 self)
			)
			(1
				(HandsOff)
				(Tail hide:)
				(Leg hide:)
				(Head hide:)
				(Ears hide:)
				(Horse
					view: 269
					loop: 0
					cel: 0
					cycleSpeed: 1
					setPri: 12
					startUpd:
					setCycle: EndLoop self
				)
				(myMusic number: 85 loop: 1 play:)
			)
			(2
				(Horse setPri: 9 stopUpd:)
				(= cycles 21)
			)
			(3
				(= cIcon 269)
				(= deathLoop 2)
				(= deathCel 2)
				(= global127 1)
				(EgoDead 69 13)
				(client setScript: 0)
			)
		)
	)
)

(instance feedNag of Script

	(method (doit)
		(if (and (== state 3) (== (Jeeves cel?) 3))
			(Hay posn: 104 145 setPri: 9 setCycle: EndLoop show:)
		)
		(if (and (== state 1) (== (Jeeves cel?) 4))
			(Hay hide:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (ego inRect: 109 138 200 150)
					(ego setMotion: MoveTo 160 135)
				)
				(if (ego inRect: 200 139 259 150)
					(ego setMotion: MoveTo 259 143)
				)
				(if (ego inRect: 204 151 263 200)
					(ego setMotion: MoveTo 189 153)
				)
				(if local4
					(Jeeves
						view: 440
						posn: 220 170
						setCycle: Walk
						setMotion: MoveTo 238 145 self
						init:
					)
				else
					(= cycles 1)
				)
			)
			(1
				(Jeeves view: 445 loop: 1 cel: 0 setCycle: EndLoop self)
			)
			(2
				(Jeeves
					view: 452
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 124 145 self
				)
			)
			(3
				(Jeeves view: 445 setLoop: 2 cel: 0 setCycle: EndLoop self)
			)
			(4
				(Jeeves
					view: 440
					setLoop: -1
					setCycle: Walk
					setAvoider: (Avoider new:)
					setMotion: MoveTo 193 145 self
				)
				(if (ego inRect: 200 162 227 176)
					(ego setMotion: MoveTo 186 170)
				)
			)
			(5
				(Jeeves setMotion: MoveTo 220 170 self)
			)
			(6
				(HandsOn)
				(= global155 8)
				(= [global368 2] (- 1700 (* global155 100)))
				(Jeeves dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance petHorse of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					setAvoider: (Avoider new:)
					setMotion: MoveTo 145 138 self
				)
			)
			(1
				(Face ego Horse)
				(ego
					view: 63
					cel: 0
					loop: 0
					setAvoider: 0
					setCycle: EndLoop self
				)
			)
			(2
				(ego cel: 0 loop: 2 setCycle: Forward)
				(= seconds 3)
			)
			(3
				(if (== ((inventory at: iCarrot) owner?) 69)
					(Print 69 14)
				else
					(Print 69 15)
					(Ears setCycle: EndLoop)
				)
				(ego cel: 0 loop: 2 setCycle: EndLoop self)
			)
			(4
				(ego view: 0 loop: 1 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance saddle of RPicView
	(properties
		y 109
		x 268
		view 169
		loop 1
		cel 2
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'detach,use,get/saddle')
					(Said 'attach/saddle')
					(Said 'saddle/blaze')
				)
				(Print 69 16)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/saddle'))
				(event claimed: TRUE)
				(Print 69 17)
			)
		)
	)
)

(instance trough of RPicView
	(properties
		y 153
		x 73
		view 169
		loop 1
		cel 1
		signal ignrAct ;add to wak.
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/trough,water')
			)
			(event claimed: TRUE)
			(Print 69 18)
		)
	)
)

(instance bridle of RPicView
	(properties
		y 96
		x 142
		view 169
		loop 1
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'detach,use,get/bit')
				(Print 69 19)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/bit'))
				(event claimed: TRUE)
				(Print 69 20)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 147
		x 100
		view 169
		priority 9
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'enter,(go<in)/room,archway')
				(Print 69 21)
			)
			((Said 'open,enter,(go<in)/room,archway')
				(if (& (ego onControl: FALSE) cGREEN)
					(if (== local0 0)
						(Room69 setScript: myDoor)
					else
						(AlreadyOpen)
					)
				else
					(Print 69 22)
				)
			)
			((Said 'close/archway,room')
				(if (== local0 1)
					(Room69 setScript: myDoor)
				else
					(AlreadyClosed)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/archway,room')
				)
				(event claimed: TRUE)
				(Print 69 23)
			)
		)
	)
)

(instance Lamp of Prop
	(properties
		y 110
		x 42
		view 169
		loop 1
		priority 7
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/lantern,lamp,ignite')
				)
				(event claimed: TRUE)
				(Print 69 5)
			)
			((Said 'get/lantern,ignite')
				(if (< (ego distanceTo: Lamp) 45)
					(Lamp dispose:)
					(= gotItem TRUE)
					(ego get: iLantern)
				else
					(NotClose)
				)
			)
		)
	)
)

(instance Hay of Prop
	(properties
		y 141
		x 228
		view 445
		loop 3
		cel 4
	)
)

(instance Leg of Prop
	(properties
		y 141
		x 104
		view 169
		loop 4
		signal ignrAct
		cycleSpeed 2
	)
)

(instance Tail of Prop
	(properties
		y 104
		x 62
		view 169
		loop 3
;;;		signal ignrAct
		cycleSpeed 2
	)
)

(instance Ears of Prop
	(properties
		y 94
		x 119
		view 169
		loop 5
;;;		signal ignrAct
	)
)

(instance Mouth of Prop
	(properties
		y 105
		x 105
		view 8
		loop 3
	)
)

(instance Head of Prop
	(properties
		y 108
		x 99
		view 169
		loop 2
		cel 1
	)
)

(instance Horse of Prop
	(properties
		y 140
		x 51
		view 169
		loop 2
		
	)
	
	(method (handleEvent event)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/blaze'))
				(event claimed: TRUE)
				(Print 69 24)
			)
			((or (Said 'bit/blaze') (Said 'attach,attach/bit/blaze'))
				(Print 69 25)
			)
			((Said '(feed,deliver,hold)>')
				(cond 
					((Said '/carrot')
						(cond 
							((== ((inventory at: iCarrot) owner?) 69)
								(Print 69 26)
							)
							((ego has: iCarrot)
								(if (& (ego onControl: FALSE) cGREEN)
									(Room69 setScript: feedHorse)
								else
									(NotClose)
								)
							)
							(else
								(DontHave)
							)
						)
					)
					((Said '/(bale[<blaze]),blaze')
						(Print 69 27)
					)
					((Said '/food')
						(Print 69 28)
					)
					((Said '/*')
						(event claimed: TRUE)
						(if (and theInvItem haveInvItem)
							(Print 69 29)
						else
							(DontHave)
						)
					)
				)
			)
			((Said 'ask[/blaze]/c<about')
				(myEd number: 118 loop: 1 play:)
				(Print 69 30)
			)
			((Said 'ask,tell[/blaze]/*<about')
				(Print 69 31)
			)
			((Said '/blaze>')
				(cond 
					((Said 'converse')
						(Print 69 32)
					)
					((Said '(get<on),mount,mount,climb')
						(Print 69 33)
					)
					((Said 'guide,move,press,get,get')
						(if (== ((inventory at: iCarrot) owner?) 69)
							(Print 69 34)
						else
							(Print 69 21)
						)
					)
					((Said 'feed,deliver/carrot')
						(cond 
							((== ((inventory at: iCarrot) owner?) 69)
								(Print 69 26)
							)
							((ego has: 17)
								(if (& (ego onControl: FALSE) cGREEN)
									(theGame setCursor: 999 (HaveMouse)) ;clear inv cursor, switch to walk	
									(= itemIcon 601)	
									(Horse signal: ignrAct)
									(Room69 setScript: feedHorse)
									
									
								else
									(NotClose)
								)
							)
							(else
								(Print 69 28)
							)
						)
					)
					((Said 'call')
						(Print 69 35)
					)
					((Said 'kiss')
						(if (== ((inventory at: iCarrot) owner?) 69)
							(Print 69 36)
						else
							(Print 69 37)
						)
					)
					((Said 'kill')
						(Print 69 38)
					)
					((Said 'pat,pat')
						(if (< (ego distanceTo: Horse) 105)
							(Room69 setScript: petHorse)
						else
							(NotClose)
						)
					)
				)
			)
		)
	)
)

(instance Jeeves of Actor
	(properties
		y 145
		x 238
		view 440
	)
	
	(method (handleEvent)
		(cond 
			((Said 'examine/butler')
				(Print 69 39)
			)
			((Said '*/butler')
				(Print 69 40)
			)
		)
	)
)

(instance myMusic of Sound)

(instance myEd of Sound)

(instance hay1 of RFeature
	(properties
		nsTop 145
		nsLeft 137
		nsBottom 163
		nsRight 169
	)
	
	(method (handleEvent event)
		(cond 
			((or (Said 'drink[/water]') (Said 'get/drink'))
				(Print 69 41)
			)
			((Said 'get/water')
				(Print 69 42)
			)
			((Said 'examine<in/water,trough')
				(Print 69 43)
			)
			((Said 'get/bale')
				(Print 69 44)
			)
			((Said 'search,(examine<in)/bale')
				(if (ego inRect: 193 128 241 142)
					(Print 69 45)
				else
					(NotClose)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/bale'))
				(event claimed: TRUE)
				(Print 69 46)
			)
		)
	)
)

(instance hay2 of RFeature
	(properties
		nsTop 118
		nsLeft 207
		nsBottom 135
		nsRight 238
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 69 46)
		)
	)
)

(instance window1 of RFeature
	(properties
		nsTop 62
		nsLeft 171
		nsBottom 81
		nsRight 198
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said '/window'))
			(event claimed: TRUE)
			(Print 69 47)
		)
	)
)

(instance window2 of RFeature
	(properties
		nsTop 69
		nsLeft 213
		nsBottom 87
		nsRight 241
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 69 47)
		)
	)
)

(instance window3 of RFeature
	(properties
		nsTop 8
		nsLeft 69
		nsBottom 26
		nsRight 95
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 69 47)
		)
	)
)
