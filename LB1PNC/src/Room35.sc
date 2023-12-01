;;; Sierra Script 1.0 - (do not remove this comment)
(script# 35) ;229 236
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use User)

(public
	Room35 0
)
(synonyms
	(room kitchen)
)

(local
	local0
	local1
	firstTime
	askedCelie
	temp7
)
(procedure (localproc_000c)
	(addToPics dispose:)
	(cast eachElementDo: #hide)
	(DrawPic 992 IRISIN TRUE 0)
)

(procedure (localproc_002a)
	(cls)
	(DrawPic 35 IRISOUT TRUE 0)
	(addToPics
		add: sink butterchurn stool rack icebox shelves shelf
		eachElementDo: #init
		doit:
	)
	(cast eachElementDo: #show)
)

(instance Room35 of Room
	(properties
		picture 35
	)
	
	(method (init)
		(= west 34)
		(super init:)
		(= global202 0)
		(= firstTime (FirstEntry))
		(LoadMany SOUND 43 44)
		(addToPics
			add: sink butterchurn stool rack icebox shelves shelf
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				sink
				butterchurn
				stool
				icebox
				shelves
				Stove
				Window1
				Window2
				rack
				Cabinet
				Table
		)
		(kettle setPri: 5 init:)
		(if howFast
			(lamp1 setCycle: Forward init:)
			(lamp2 setCycle: Forward init:)
			(if (< currentAct 2) (kettle loop: 0 setCycle: Forward))
		else
			(lamp1 init: stopUpd:)
			(lamp2 init: stopUpd:)
		)
		(iceDoor setPri: 5 init: stopUpd:)
		(if (== ((inventory at: iSoupBone) owner?) 35)
			(Bone setPri: 4 init: stopUpd:)
		)
		(if
			(and
				(<= (Random 1 100) 35)
				(> currentAct 1)
				(< currentAct 7)
			)
			(Shadow illegalBits: 0 posn: 13 82 setPri: 2 init:)
			(Shadow setScript: shadowWalk)
		)
		(User canControl: TRUE)
		(switch currentAct
			(0 (self setRegions: 229))
			(1 (self setRegions: 236))
		)
		(Fdoor
			cel: (if (== prevRoomNum 12) 2 else 0)
			ignoreActors: TRUE
			init:
			stopUpd:
		)
		(= gDoor Fdoor)
		(Bdoor
			cel: (if (== prevRoomNum 12) 2 else 0)
			setPri: 9
			ignoreActors: TRUE
			init:
			stopUpd:
		)
		(= gMySound Bdoor)
		(if (== prevRoomNum 34)
			(ego posn: 1 123)
		else
			(HandsOff)
			(User mapKeyToDir: TRUE)
			(User canControl: TRUE)
			(ego posn: 235 120)
			(if (not firstTime)
				(self setScript: closeDoor)
				(User canControl: TRUE)
			)
		)
		(ego view: 0 illegalBits: -32732 init:)
	)
	
	(method (doit)
		(if firstTime
			(= firstTime 0)
			(Print 35 0)
			(if (== currentAct 0)
				(Print 35 1)
			)
			(if (== prevRoomNum 12)
				(self setScript: closeDoor)
			)
		)
		(if
			(and
				(& (ego onControl: 0) cRED)
				(not local0)
				(== (ego loop?) 0)
			)
			(HandsOff)
			(User mapKeyToDir: TRUE)
			(= local0 1)
			(ego setScript: myDoor)
		)
		(if (& (ego onControl: origin) cGREEN)
			(curRoom newRoom: 12)
		)
		(cond 
			((< (ego x?) 100) (= vertAngle 0))
			((< (ego x?) 160) (= vertAngle 167))
			(else (= vertAngle 137))
		)
		(switch global202
			(1 (localproc_000c))
			(2 (localproc_002a))
		)
		(= global202 0)
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
			(if (ClickedInRect 0 12 111 128 event) ;exit room
			(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo -5 119)
						)
						(else
								(event claimed: FALSE)
						)
					 )
				
				)
						
					
				(if (ClickedOnObj sink (event x?) (event y?)) ;lamp
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine sink})
					)
					(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnObj butterchurn (event x?) (event y?)) ;lamp
					(event claimed: TRUE)
					(switch theCursor
					(995
							(DoVerb {examine in butterchurn})
					)
					(998
							(DoVerb {examine butterchurn})
					)					
					(else
							(event claimed: FALSE)
						)
					)
				)					
				(if (ClickedOnObj stool (event x?) (event y?)) ;lamp
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine chair})
					)					
					(else
							(event claimed: FALSE)
						)
					)
				)					
				(if (ClickedOnObj rack (event x?) (event y?)) ;lamp
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine pan})
					)					
					(else
							(event claimed: FALSE)
						)
					)
				)			
				(if (ClickedOnObj icebox (event x?) (event y?)) ;lamp
					(event claimed: TRUE)
					(switch theCursor
					(605 ;soup devolver
						(DoVerb {get back bone})
											)
					(998
							(DoVerb {examine freezer})
					)		
					(995
							(DoVerb {get bone})
							
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)		
				(if (and (ClickedOnObj shelves (event x?) (event y?)) ;lamp
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine armoire})
					)		
					(995
							(DoVerb {examine in armoire})
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)		
				(if (or (ClickedOnObj lamp1 (event x?) (event y?)) ;lamp
					(ClickedOnObj lamp2 (event x?) (event y?)) );lamp
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine armoire})
					)		
					(995
							(DoVerb {examine in armoire})
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)
				(if (or (ClickedOnObj Fdoor (event x?) (event y?)) 
					(ClickedOnObj Bdoor (event x?) (event y?)) )
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine door})
					)		
								
					(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (and (ClickedOnObj kettle (event x?) (event y?)) ;lamp
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
					(995
						(= temp7
												(Print
;;;													{Caldron}
;;;													#button {Open} 1
;;;													#button {Get} 2
;;;													#button {Drink} 3
													{Caldero}
													#button {Abrir} 1
													#button {Coger} 2
													#button {Beber} 3						
	

												)
											)
											(switch temp7
												(1 
													(DoVerb {open caldron})
														
												)
						
												(2 
													(DoVerb {get caldron})
														
												)
												(3 
													(DoVerb {drink coffee})
														
												)																						

											
												(else
						
													(event claimed: FALSE)
												)
											)
						
					)		
					(998
							(DoVerb {look cauldron})
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)		
				
				(if (and (ClickedOnObj Stove (event x?) (event y?)) ;lamp
						(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
					(995				
							(DoVerb {open oven})
					)
					(998
						(DoVerb {examine oven})
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)							
				(if (or (ClickedOnObj Window1 (event x?) (event y?)) 
					(ClickedOnObj Window2 (event x?) (event y?)) )
					(event claimed: TRUE)
					(switch theCursor
					(998	
							(DoVerb {look window})
					)									
					(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnObj Table (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
					(998
							(DoVerb {examine nightstand})
					)		
								
					(else
							(event claimed: FALSE)
						)
					)
				)
				(if (and (ClickedOnObj Cabinet (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					
					(event claimed: TRUE)
					(switch theCursor
					(998
							(Print 35 22)
							(event claimed: TRUE)
					)		
								
					(else
							(event claimed: FALSE)
						)
					)
				)													
			)
		)
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		(DisposeScript 990)
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(if (== (event type?) saidEvent)
				(= temp0
					(cond 
						((!= currentAct 1))
						((not (Said 'ask[/celie]/lil<about>')) (not (Said 'ask[/lil]/celie<about>')))
					)
				)
				(if global208
					(if temp0
						(if
							(Said
								'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
							)
							(self setScript: (ScriptID 243 0))
							((self script?) handleEvent: event)
						)
					)
				)
				(if (event claimed?) (return TRUE))
				(cond 
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]')
								(Print 35 0)
								(if (== currentAct 0)
									(Print 35 1))
								)
							((Said '/dish')
								(if (== currentAct 0)
									(Print 35 2)
								else
									(Print 35 3)
								)
							)
							((Said '/door')
								(Print 35 4)
							)
							((Said '/carpet')
								(Print 35 5)
							)
							((Said '<(in,below)/nightstand')
								(Print 35 6)
							)
						)
					)
					((Said 'scrub/deliver')
						(Print 35 7)
					)
					((Said 'get/dish')
						(if (== currentAct 0)
							(Print 35 8)
						else
							(Print 35 3)
						)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(cls)
		(super newRoom: n)
	)
)

(instance shadowWalk of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 8))
			(1
				(Shadow setMotion: MoveTo 295 82 self)
			)
			(2
				(Shadow dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(ego illegalBits: 0)
				(if (> (ego x?) 229)
					(ego setMotion: MoveTo 229 (ego y?) self)
				else
					(= cycles 1)
				)
			)
			(2
				(Bdoor cycleSpeed: 1 ignoreActors: TRUE setCycle: EndLoop)
				(Fdoor cycleSpeed: 1 ignoreActors: TRUE setCycle: EndLoop self)
				(mySound number: 43 play:)
			)
			(3
				(ego setMotion: MoveTo (+ (ego x?) 50) 122)
			)
		)
	)
)

(instance frigDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(iceDoor setCycle: EndLoop self)
			)
			(1
				(if (== ((inventory at: iSoupBone) owner?) 35)
					(Print 35 9)
					(= gotItem TRUE)
					(ego get: iSoupBone)
					(Bone dispose:)
				else
					(Print 35 10)
				)
				(= cycles 1)
			)
			(2
				(iceDoor setCycle: BegLoop self)
			)
			(3
				(HandsOn)
				(iceDoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance closeDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(ego ignoreActors: 0 setMotion: MoveTo 226 122 self)
				(Fdoor setCycle: BegLoop)
				(Bdoor setCycle: BegLoop)
				(mySound number: 44 play:)
			)
			(2
				(HandsOn)
				(User mapKeyToDir: TRUE)
				(User canControl: TRUE)				
				(Bdoor stopUpd:)
				(Fdoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance sink of RPicView
	(properties
		y 81
		x 217
		view 135
		cel 1
		priority 4
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/sink'))
			(event claimed: TRUE)
			(if (== currentAct 0)
				(Print 35 11)
			else
				(Print 35 12)
			)
		)
	)
)

(instance butterchurn of RPicView
	(properties
		y 166
		x 21
		view 135
		cel 3
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/butterchurn')
				(Print 35 13)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/butterchurn')
				)
				(event claimed: TRUE)
				(Print 35 14)
			)
		)
	)
)

(instance stool of RPicView
	(properties
		y 152
		x 198
		view 135
		cel 2
		priority 10
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/chair,barstool')
			)
			(event claimed: TRUE)
			(Print 35 15)
		)
	)
)

(instance rack of RPicView
	(properties
		y 66
		x 220
		view 135
		loop 1
		cel 2
		priority 3
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/pan'))
			(event claimed: TRUE)
			(Print 35 16)
		)
	)
)

(instance icebox of RPicView
	(properties
		y 91
		x 27
		view 135
		priority 3
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'open,(examine<in)/freezer')
					(and
						(== ((inventory at: iSoupBone) owner?) 35)
						(Said 'get/bone')
					)
				)
				(if (ego inRect: 9 84 43 100)
					(ego setScript: frigDoor)
				else
					(NotClose)
				)
			)
			((and global208 (Said 'ask,tell'))
				(event claimed: FALSE)
			)
			(
				(and
					(!= currentAct 0)
					(or (Said '/beauregard') (Said '//beauregard'))
				)
				(Print 35 17)
			)
			(
				(and
					(== currentAct 0)
					(== ((inventory at: iSoupBone) owner?) 0)
					(or
						(Said 'get/back<bone[<from]')
						(Said 'get/*/beauregard')
						(Said 'get/bone')
					)
				)
;;;				(= itemIcon 605) ;clear menu inv item pic 
;;;				(theGame setCursor: 605 (HaveMouse)) ;clear inv cursor, switch to bone
;;;				(Print 35 18)
				(Print {Beauregard sigue jugando con su hueso.})
			)
			((Said 'get/bone')
				(cond
					((== nomorebones 1)
						(Print {Ya no necesitas m*s huesos.})	
					)
					((ego has: iSoupBone)
						(AlreadyTook)
					)
					((== ((inventory at: iSoupBone) owner?) 35)
						(DontHave)
					)
					(else
					
							
							(= itemIcon 605) ;clear menu inv item pic 
							(theGame setCursor: 605 (HaveMouse)) ;clear inv cursor, switch to bone
	;;;						(Print 35 19)
							(= gotItem TRUE)
							(ego get: iSoupBone)
							(Bone dispose:)
							(Print {Vuelves a coger otro hueso.}) 
					)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/freezer'))
				(event claimed: TRUE)
				(Print 35 20)
			)
		)
	)
)

(instance shelves of RPicView
	(properties
		y 144
		x 279
		view 135
		loop 1
		priority 10
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/armoire')
				(Print 35 21)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(event claimed: TRUE)
				(Print 35 22)
			)
		)
	)
)

(instance shelf of PicView
	(properties
		y 133
		x 150
		view 135
		loop 1
		cel 1
		priority 10
;;;		signal ignrAct
		signal $4000
	)
)

(instance lamp1 of Prop
	(properties
		y 56
		x 231
		view 135
		loop 4
		cel 1
		priority 6
;;;		signal fixPriOn
		signal $0010
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 66
		x 255
		view 135
		loop 4
		priority 11
;;;		signal fixPriOn
		signal $0010
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 113
		x 242
		view 201
		loop 1
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {door})
		)
	)
)

(instance Bdoor of Prop
	(properties
		y 125
		x 253
		view 201
		loop 3
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {door})
		)
	)
)

(instance kettle of Prop
	(properties
		y 63
		x 118
		view 235
		loop 1
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/caldron')
				(cond 
					((< currentAct 2)
						(Print 35 23)
					)
					((<= currentAct 4)
						(Print 35 24)
					)
					(else
						(Print 35 25)
					)
				)
			)
			((Said 'get/caldron')
				(if (< currentAct 2)
					(Print 35 26)
				else
					(Print 35 27)
				)
			)
			((Said 'pour,get,drink/cup,coffee')
				(Print 35 28)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine[<at]/caldron[<coffee]')
				)
				(if (< currentAct 2)
					(Print 35 29)
				else
					(Print 35 30)
				)
				(event claimed: TRUE)
			)
		)
	)
)

(instance Shadow of Actor
	(properties
		view 110
	)
)

(instance Stove of RFeature
	(properties
		nsTop 32
		nsLeft 90
		nsBottom 88
		nsRight 133
		x 32
		y 90
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/oven')
				(Print 35 31)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/oven'))
				(if (< currentAct 2)
					(Print 35 32)
				else
					(Print 35 30)
				)
				(event claimed: TRUE)
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 20
		nsLeft 46
		nsBottom 85
		nsRight 72
		x 20
		y 46
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {window})
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 20
		nsLeft 145
		nsBottom 85
		nsRight 172
		x 20
		y 145
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {window})
		)
	)
)

(instance iceDoor of Prop
	(properties
		y 84
		x 18
		view 135
		loop 3
	)
)

(instance Bone of Prop
	(properties
		y 82
		x 27
		view 135
		loop 2
		cel 1
	)
	
	(method (handleEvent)
		(cond 
			((and (< currentAct 2) (Said 'ask/celie/bone<for'))
				(= theTalker talkCELIE)
				(++ askedCelie)
				(Say 1 35 33)
			)
			((and (== currentAct 1) (Said 'ask/lil/bone<for'))
				(= theTalker talkLILLIAN)
				(Say 1 35 33)
			)
		)
	)
)

(instance mySound of Sound
	(properties
		number 43
	)
)

(instance Table of RFeature
	(properties
		nsTop 106
		nsLeft 110
		nsBottom 12
		nsRight 175
		x 106
		y 110
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/nightstand'))
			(if (== currentAct 1)
				(Print 35 34)
			else
				(Print 35 35)
			)
			(event claimed: TRUE)
		)
	)
)

(instance Cabinet of RFeature
	(properties
		nsTop 33
		nsLeft 176
		nsBottom 52
		nsRight 210
		x 33
		y 176
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(Print 35 22)
			(event claimed: TRUE)
		)
	)
)
