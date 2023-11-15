;;; Sierra Script 1.0 - (do not remove this comment)
(script# 42)
(include game.sh)
(use Main)
(use ElevGate)
(use Intrface)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)


(public
	Room42 0
)
(synonyms
	(mantel shelf)
	(drawer chest dresser)
	(room bedroom)
	(armoire armoire closet)
	(boy painting)
)

(local
	newPV
	newPV_2
	temp7
	temp8
)
(procedure (ColPrint)
	(= theTalker talkCOLONEL)
	(Say 1 &rest)
)

(instance Room42 of Room
	(properties
		picture 42
	)
	
	(method (init)
		(= horizon 0)
		(= east 43)
		(super init:)
		(addToPics
			add: bed table1 table2 table3 sofa mirror stand vase flower cannon
		)
		(if howFast
			(lamp1 setCycle: Forward init:)
			(lamp2 setPri: 11 setCycle: Forward init:)
			(logs setCycle: Forward init:)
		else
			(logs init: stopUpd:)
			(lamp1 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(addToPics eachElementDo: #init doit:)
		(self
			setRegions: 213
			setFeatures:
				table1
				table2
				table3
				bed
				sofa
				cannon
				vase
				flower
				mirror
				Armoire
				SDress
				Shaft
		)
		(if (& deadGuests deadLILLIAN)
			(Dbag init: stopUpd:)
			(addToPics add: Chair eachElementDo: #init doit:)
			(self setFeatures: Chair)
		)
		(switch prevRoomNum
			(41 (ego posn: 56 121))
			(43 (ego posn: 315 149))
			(49 (ego posn: 252 167))
		)
		(ego view: 0 illegalBits: cWHITE setPri: -1)
		(= global193 0)
		(if (not (& global109 $0030))
			(cond 
				((== currentAct 0)
					(= global193 1)
					(if
					(and (not (& global173 $0040)) (!= [global368 3] 1))
						(self setRegions: 231)
					else
						(self setRegions: 240)
					)
				)
				(
					(or
						(Btst 38)
						(and
							(< gameMinutes 3)
							(not (& deadGuests deadLILLIAN))
							(not (Btst 37))
						)
					)
					(= global193 1)
					(self
						setRegions:
						(switch currentAct
							(4 270)
							(else  240)
						)
					)
				)
				((and (== currentAct 4) (== gameMinutes 3))
					(LoadMany FONT 4 41)
					(LoadMany SOUND 29 94 95 96)
					(Load VIEW 642)
					(Load SCRIPT 406)
					(addToPics add: Chair eachElementDo: #init doit:)
					(self setFeatures: Chair setScript: missColo)
				)
			)
		)
		(if global193
			(= global111 42)

			((= newPV (PicView new:))
				view: 242
				loop: 0
				cel: 0
				x: 296
				y: 126
			)
			((= newPV_2 (PicView new:))
				view: 242
				loop: 2
				cel: 0
				x: 283
				y: 126
			)
			(addToPics add: newPV newPV_2 doit:)
			(ego init:)
;;;			(&= global109 $fff7)
			(= global109 (& global109 $fff7))			
		else
			(if
				(and
					(not (& global109 $0030))
					(not (& deadGuests $0040))
				)
				(= global111
					(switch (Random 1 3)
						(1 32)
						(2 42)
						(3 75)
					)
				)
				(if (== currentAct 1)
					(= global111 75)
				)
			)
			(= newPV_2 (ElevGate new:))
			(newPV_2
				chainID: chain
				elevatorID: elevator
				downID: down
				upID: up
				init:
			)
		)
	)
	
	(method (doit)
		(if (and (FirstEntry) (not (& global109 $0010)))
			(if (== global111 curRoomNum)
				(Print 42 0)
			else
				(Print 42 1)
			)
		)
		(if (& (ego onControl: origin) cGREEN)
			(curRoom newRoom: 41)
		)
		(if (not (& global109 $0020))
			(if (ego inRect: 137 144 176 161)
				(ego setPri: 14)
			else
				(ego setPri: -1)
			)
		)
		(cond 
			((< (ego x?) 140) (= vertAngle 44))
			((< (ego x?) 260) (= vertAngle 27))
			(else (= vertAngle 18))
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 201)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)		
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
			(if (and (ClickedOnPicView newPV_2 (event x?) (event y?))
				(== global111 42)
				(if (& global109 $0010)))
				

					(event claimed: TRUE)

					(switch theCursor
						(619
							(= temp7

								(PrintSpecial
									{Ascensor}
									#button {Bloquear} 1
									#button {Desbloquear} 2
									
;;;									{Elevator}
;;;									#button {Lock} 1
;;;									#button {Unlock} 2							
								)
							)
							(switch temp7
								(1
								    ;(DoVerb {latch elevator})
								    (DoVerb {lock elevator})
								)
								(2
									;(DoVerb {unbar elevator})
									(DoVerb {unlock elevator})
								)
								(else
									(event claimed: FALSE)
								)
							)
						

					
					)
					
						(998	
							(= temp7
								(PrintSpecial
									{ }
									#button {Examinar Control} 1
									#button {Examinar Agujero} 2	
									#button {Examinar Eje} 3
;;;									#button {Examine Control} 1
;;;									#button {Examine Keyhole} 2	
;;;									#button {Examine Shaft} 3							
								)
							)
							(switch temp7
								(1
								    (DoVerb {examine control})	
								)
								(2
									(DoVerb {examine keyhole})
								)
								(3
									(DoVerb {examine shaft})
								)						
								(else
									(event claimed: FALSE)
								)
							)
						)
						(999	
							(= temp7
								(PrintSpecial
									{Ascensor}
									#button {Entrar} 1
									#button {Salir} 2
;;;									{Elevator}
;;;									#button {Enter} 1
;;;									#button {Exit} 2							
								)
							)
							(switch temp7
								(1
								    (DoVerb {open elevator})
								)
								(2
									(DoVerb {close elevator})
								)
								(else
									(event claimed: FALSE)
								)
							)
						)
						(995
							(= temp7
								(PrintSpecial
									{Elevator}
									#button {Open} 1
									#button {Close} 2
									#button {Arriba} 3
									#button {Abajo} 4								
;;;									#button {Open} 1
;;;									#button {Close} 2								
;;;									#button {Press Up} 3
;;;									#button {Press Down} 4
								)		

							)
							(switch temp7
								(1
								    (DoVerb {open elevator})
								)
								(2
									(DoVerb {close elevator})
								)
								(3
								    (DoVerb {move up})
								)
								(4
									(DoVerb {move down})
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
				(if (ClickedOnPicView bed (event x?) (event y?)) 				
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {bed})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnPicView table1 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {table})
						)
						(else	
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnPicView table2 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {table})
						)
						(else	
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnPicView table3 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {table})
						)
						(else	
							(event claimed: FALSE)
						)
					)
				)		
				;Bug with colonel.		
;;;				(if (ClickedOnPicView sofa (event x?) (event y?)) 					
;;;					(event claimed: TRUE)
;;;					(switch theCursor	
;;;						(998
;;;							(DoLook {sofa})
;;;						)
;;;						(else
;;;							(event claimed: FALSE)
;;;						)
;;;					)
;;;				)
				(if (ClickedOnPicView mirror (event x?) (event y?))
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {mirror})
						)
						(else			
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnPicView stand (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {stand})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnPicView vase (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {vase})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnPicView flower (event x?) (event y?)) 				
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {vase}) ;vase
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnPicView cannon (event x?) (event y?))	
					(event claimed: TRUE)
					(switch theCursor	
						(619 ;key
							(DoVerb {attach key cannon})
							(Print 42 30)
						)
						(995
								(DoVerb {get key})
						)
						(998
							(= temp7
								(Print
;;;									{Cannon}
;;;									#button {Look} 1
;;;									#button {Examine in} 2	
									{Ca>on}
									#button {Mirar} 1
									#button {Examinar} 2										
								)
							)
							(switch temp7
								(1 		
									(DoVerb {look cannon})
								)
								(2
									(DoVerb {look in cannon})
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
				(if (ClickedOnObj Armoire (event x?) (event y?)) 			
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine panel door}) ;panel yes.
						)
						(995
							(DoVerb {move panel door})	
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnObj SDress (event x?) (event y?)) 				
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {open drawer})	
						)
						(998
							(event claimed: TRUE)
							(Print 42 37)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
;;;				(if (and (ClickedOnObj Shaft (event x?) (event y?)) ;elevator	
;;;					(event claimed: TRUE)
;;;					(switch theCursor	
;;;						(998
;;;							(DoVerb {look elevator})	
;;;						)
;;;						(995
;;;							(DoVerb {open elevator})
;;;						)
;;;						(else
;;;							(event claimed: FALSE)
;;;						)
;;;					)
;;;				)	
				(if (ClickedOnObj Dbag (event x?) (event y?))
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(= temp7
								(Print
									{Bag}
									#button {Get} 1
									#button {Open} 2								
								)
							)
							(switch temp7
								(1
									(DoVerb {get bag})
								)
								(2
									(DoVerb {open bag})
								)
							)
						)
						(998
							(= temp7
								(Print
									{Bag}
									#button {look} 1
									#button {examine} 2								
								)
							)
							(switch temp7
								(1 
									(DoVerb {look bag})
								)
								(2
									(DoVerb {examine in bag})
								)
							)
						)	
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnObj logs (event x?) (event y?))	
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine log})
						)
						(else
							(event claimed: FALSE)
						)			
					)
				)
				(if (ClickedOnObj lamp1 (event x?) (event y?))			
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {look lamp})
						)
						(else
							(event claimed: FALSE)
						)			
					)
				)	
				(if (ClickedOnObj lamp2 (event x?) (event y?))
					(event claimed: TRUE)
					(switch theCursor
						(998
							(DoVerb {look lamp})
						)
						(else
							(event claimed: FALSE)
						)			
					)
				)								
				(if (ClickedOnPicView Chair (event x?) (event y?))
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {look wheelchair})
						)
						(else
							(event claimed: FALSE)
						)			
					)
				)	
				(if (ClickedInRect 312 319 137 155 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo 321 147)
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)
			)
		)
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(DisposeScript SAVE)
			(if
				(and
					global208
					(Said
						'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0))
				((self script?) handleEvent: event)
				(if (event claimed?) (return))
			)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(if (== global111 curRoomNum)
								(Print 42 0)
							else
								(Print 42 1)
							)
						)
						((Said '/mantel')
							(Print 42 2)
						)
						((Said '<in/elevator,lift')
							(if (not (& global109 $0010))
								(Print 42 3)
							else
								(event claimed: FALSE)
							)
						)
						((Said '/elevator,lift') (Print 42 4))
						((Said '/archway') (Print 42 5))
						((Said '/blind') (Print 42 6))
						((and global193 (Said '/wheelchair')) (Print 42 7))
						((Said '/eye,(boy<eye)') (Print 42 8))
						((Said '<behind,below/boy') (Print 42 9))
						((or (Said '/boy') (Said 'examine/boy/boy')) (Print 42 10))
					)
				)
				((Said 'move,get/boy') (Print 42 11))
				((and (not global193) (Said 'get,move,press/wheelchair'))
					(Print 42 12)
				)
				((Said 'get>')
					(cond 
						((Said '/key[<brass]')
							(cond 
								((not ((inventory at: iBrassKey) ownedBy: 42))
									(AlreadyTook)
								)
								((& (ego onControl: origin) cMAGENTA)
									(if ((inventory at: iBrassKey) ownedBy: 42)
										(if (!= global193 1)
											(= gotItem TRUE)
											(ego get: iBrassKey)
											(Print 42 13)
										else
											(ColPrint 42 14)
										)
									else
										(DontSee)
									)
								)
								(else
									(NotClose)
								)
							)
						)
						((Said '/cannon')
							(Print 42 15)
						)
					)
				)
				((and (not global193) (Said 'sit/wheelchair'))
					(Print 42 16)
				)
				(global193
					(cond 
						(
							(Said
								'open,enter,go/archway,elevator,lift[<elevator,lift]'
							)
							(ColPrint 42 17)
						)
						((Said 'smoke/butt') (Print 42 18))
						((Said 'sit[<down,in<in]/wheelchair') (Print 42 19))
						((Said 'press,move/wheelchair,colonel') (Print 42 20))
					)
				)
			)
		)
	
			)
		
	
	(method (newRoom n)
		(if (and (!= n 41) (== global201 200))
			(++ global201)
;;;			(|= deadGuests deadRUDY)
			(= deadGuests (| deadGuests deadRUDY))
		)
		(super newRoom: n)
	)
)

(instance missColo of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
					((not (& global118 $0004))
						(= global118 (| global118 $0004))	
;;;						(|= global118 $0004)
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
					((self script?) (= state -1))
				)
				(= cycles 1)
			)
			(1
				(Bset 37)
				(client setScript: 0)
			)
		)
	)
)

(instance bed of RPicView
	(properties
		y 167
		x 121
		view 142
		loop 1
		cel 2
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine[<!*]/bed'))
			(Print 42 21)
			(event claimed: TRUE)
		)
	)
)

(instance table1 of RPicView
	(properties
		y 167
		x 148
		view 142
		loop 1
		cel 3
		priority 15
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 167
		x 69
		view 142
		loop 1
		cel 3
		priority 15
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance sofa of RPicView
	(properties
		y 125
		x 158
		view 142
		loop 1
		priority 8
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {couch})
		)
	)
)

(instance mirror of RPicView
	(properties
		y 141
		x 41
		view 142
		loop 1
		cel 1
		priority 9
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'examine[<at]/reflection')
					(Said 'examine<in/mirror')
				)
				(if (< (ego distanceTo: mirror) 60)
					(= theTalker talkLAURA)
					(Say 0 42 22)
				else
					(NotClose)
				)
			)
			((Said 'examine<behind,below/mirror')
				(Print 42 23)
			)
			((Said 'get,move/mirror')
				(Print 42 24)
			)
			((Said 'examine/mirror')
				(Print 42 25)
			)
			((Said 'open,(examine<in)/vanity,(nightstand<dressing)')
				(Print 42 26)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/vanity,(nightstand<dressing)')
				)
				(Print 42 27)
				(event claimed: TRUE)
			)
		)
	)
)

(instance table3 of RPicView
	(properties
		y 123
		x 202
		view 142
		loop 1
		cel 4
		priority 8
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance cannon of RPicView
	(properties
		y 52
		x 190
		view 142
		loop 1
		cel 5
	)
	
	(method (handleEvent event)
		(cond 
			(
			(Said 'search,(examine<(in,in,in))/cannon,barrel')
				(if (& (ego onControl: origin) cMAGENTA)
					(if ((inventory at: iBrassKey) ownedBy: 42)
						(Print 42 28)
					else
						(Print 42 29)
					)
				else
					(NotClose)
				)
			)
			((Said 'attach/key/cannon')
				(Print 42 30)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/cannon'))
				(event claimed: TRUE)
				(Print 42 31)
			)
		)
	)
)

(instance vase of RPicView
	(properties
		y 52
		x 210
		view 142
		loop 1
		cel 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {vase})
		)
	)
)

(instance flower of RPicView
	(properties
		y 52
		x 170
		view 142
		loop 1
		cel 8
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {vase})
		)
	)
)

(instance Chair of RPicView
	(properties
		y 150
		x 217
		view 142
		loop 1
		cel 9
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/wheelchair'))
			(event claimed: TRUE)
			(Print 42 32)
		)
	)
)

(instance stand of PicView
	(properties
		y 90
		x 169
		view 142
		loop 1
		cel 6
	)
)

(instance logs of Actor ;Prop
	(properties
		y 86
		x 189
		view 142
		loop 2
		priority 5
		cycleSpeed 1
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/oak,log'))
			(event claimed: TRUE)
			(DoLook {fire})
		)
	)
)

(instance lamp1 of Actor ;Prop
	(properties
		y 44
		x 80
		view 142
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Actor ;Prop
	(properties
		y 76
		x 15
		view 142
		cel 1
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance Dbag of Actor ;Prop
	(properties
		y 120
		x 220
		view 142
		loop 1
		cel 10
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(cond 
			((Said 'get/bag')
				(Print 42 33)
			)
			((Said 'open/bag')
				(AlreadyOpen)
			)
			((Said 'examine<in/bag')
				(if (< (ego distanceTo: Dbag) 10)
					(Print 42 34)
				else
					(NotClose)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/bag,dirt')
					(Said 'examine<down')
				)
				(event claimed: TRUE)
				(Print 42 35)
			)
		)
		(if (event claimed?)
			(Bset 32)
		)
	)
)

(instance chain of Actor)

(instance elevator of Actor
	(properties
		y -10
	)
)

(instance down of View)

(instance up of View)

(instance Shaft of RFeature
	(properties
		nsTop 65
		nsLeft 284
		nsBottom 126
		nsRight 311
		y 65
		x 284
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {elevator})
		)
	)
)

(instance SDress of RFeature
	(properties
		nsTop 53
		nsLeft 92
		nsBottom 87
		nsRight 124
	)
	
	(method (handleEvent event)
		(cond 
			((Said '(examine<in),open/drawer') (Print 42 36))
			((or (MousedOn self event shiftDown) (Said 'examine/drawer'))
				(event claimed: TRUE)
				(Print 42 37)
			)
		)
	)
)

(instance Armoire of RFeature
	(properties
		nsTop 67
		nsLeft 256
		nsBottom 127
		nsRight 274
	)
	
	(method (handleEvent event)
		(cond 
			((Said '/panel,(door<hidden)>')
				(cond 
					((Said 'examine')
						(if (& global175 $0010)
							(Print 42 38)
						else
							(Print 42 39)
						)
					)
					((and (& global175 $0010) (Said 'open,move'))
						(if (not global193)
							(if (& (ego onControl: origin) cLGREY)
								(curRoom newRoom: 49)
							else
								(NotClose)
							)
						else
							(Print 42 40)
						)
					)
				)
			)
			((Said 'move/armoire') (Print 42 41))
			(
				(or
					(Said 'examine<(in,in,in)/armoire')
					(Said 'open/armoire,(door<armoire)')
				)
				(Print 42 42)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(event claimed: TRUE)
				(Print 42 43)
			)
		)
	)
)


;ASCENSOR ROOM201
