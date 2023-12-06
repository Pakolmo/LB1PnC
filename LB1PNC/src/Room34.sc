;;; Sierra Script 1.0 - (do not remove this comment)
(script# 34) ;237 213  403 383
(include game.sh)
(use Main)
(use Intrface)
(use DCIcon)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room34 0
)

(local
	local0
	local1
	local2
	local3
	temp7
	chutes
	chutemoving
)
(instance Room34 of Room
	(properties
		picture 34
	)
	
	(method (init)
		(super init:)
		(= west 33)
		(Load VIEW 22)
		(LoadMany SOUND 9 47 74 75)
		(addToPics
			add:
				chair1
				chair2
				chair3
				chair4
				chair5
				chair6
				chair7
				chair8
				chair9
				chair10
				chair11
				chair12
				coffee
				chandelier
				flowers
			eachElementDo: #init
			doit:
		)
		(self
			setRegions: 213
			setFeatures:
				Table
				chair7
				chair8
				chair9
				chair10
				chair11
				chair12
				BigTable
				chair1
				chair2
				chair3
				chair4
				chair5
				chair6
				coffee
				chandelier
				Hutch
				Mirror
		)
		(if howFast
			(gas setPri: 9 ignoreActors: TRUE setCycle: Forward init:)
			(fire loop: (/ currentAct 2) setCycle: Forward init:)
		else
			(gas setPri: 9 ignoreActors: TRUE init: stopUpd:)
			(fire loop: (/ currentAct 2) init: stopUpd:)
		)
		(chute
			setLoop: 2
			yStep: 5
			illegalBits: 0
			setPri: 2
			ignoreActors: TRUE
			init:
			stopUpd:
			setScript: chuteActions
		)
		(chutefake
			setLoop: 6
			setCel: 0
			yStep: 5
			illegalBits: 0
			setPri: 2
			ignoreActors: TRUE
			init:
			stopUpd:
			setScript: chuteActions
		)		
		(if
			(and
				(<= (Random 1 100) 35)
				(> currentAct 0)
				(< currentAct 7)
			)
			(Shadow illegalBits: 0 posn: 13 82 setPri: 2 init:)
			(Shadow setScript: shadowWalk)
		)
		(switch currentAct
			(1
				(if (== global154 3)
					(if (== [global368 0] 1)
						(= global154 4)
					else
						(if (== global154 3)
							(User canInput: FALSE)
						)
						(= local2 1)
						(self setRegions: 237)
					)
				)
			)
			(4
				(= local2 1)
				(self setRegions: 403)
			)
			(3
				(if (and (== gameMinutes 3) (== [global368 2] 0))
					(= [global368 2] 1800)
				)
				(if (> [global368 2] 1)
					(= local2 1)
					(self setRegions: 383)
				)
			)
		)
		(if (!= prevRoomNum 50)
			(if (== prevRoomNum 33)
				(ego posn: 14 150)
			else
				(ego posn: 265 120)
			)
;;;			(ego illegalBits: cWHITE view: 0 init:)
			(ego illegalBits: -32768 view: 0 init:)
		else
			(ego
				view: 0
;;;				illegalBits: cWHITE
				illegalBits: -32768
				setPri: -1
				posn: 68 167
				init:
			)
			(= local3 1)
		)
	)
	
	(method (doit)
		(if local3
			(= local3 0)
			(Print 34 0)
		)
		(if (FirstEntry)
			(Print 34 1)
		)
		(if (& (ego onControl: origin) cGREEN)
			(curRoom newRoom: 35)
		)
		(if (not local1)
			(if (and (< (ego x?) 51) (> (ego y?) 126))
				(ego setPri: 10)
			else
				(ego setPri: -1)
			)
		)
		(cond 
			((< (ego x?) 30)
				(= vertAngle 0)
			)
			((< (ego x?) 140)
				(= vertAngle 163)
			)
			(else
				(= vertAngle 137)
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
				(if (ClickedOnObj chair1 (event x?) (event y?)) 	
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(event claimed: TRUE)
							(DoLook {chair})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if
					(or
						(ClickedOnObj chair2 (event x?) (event y?)) 
						(ClickedOnObj chair3 (event x?) (event y?)) 
						(ClickedOnObj chair4 (event x?) (event y?)) 
						(ClickedOnObj chair5 (event x?) (event y?)) 
						(ClickedOnObj chair6 (event x?) (event y?)) 
						(ClickedOnObj chair7 (event x?) (event y?)) 
						(ClickedOnObj chair8 (event x?) (event y?)) 
						(ClickedOnObj chair9 (event x?) (event y?)) 
						(ClickedOnObj chair10 (event x?) (event y?)) 
						(ClickedOnObj chair11 (event x?) (event y?)) 
						(ClickedOnObj chair12 (event x?) (event y?))
					)	
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(event claimed: TRUE)
							(DoLook {chair})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if
					(and
						(ClickedOnObj chutefake (event x?) (event y?)) 
						(== local0 1)
					)
					(event claimed: TRUE)
					(switch theCursor	
						(999
							(DoVerb {close chute})
						)
						(998		
							(if local0
								(Print 44 10)
							else
								(DoLook {chute})
							)
						)
						(995
							(= chutes
								(Print
;;;									{Chute Actions}
;;;									#button {Open Door} 1
;;;									#button {Enter Chute} 2
;;;									#button {Close Door} 3		
									{Rampa}
									#button {Abrir Puerta} 1
									#button {Entrar} 2								
									#button {Cerrar Puerta} 3
								)
							)
							(switch chutes
								(1 ;Abrir Puerta
									(= newEvent (Event new:))
									(newEvent
										type: evKEYBOARD
										message: {open chute door}
										modifiers: 999
										claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
									(User mapKeyToDir: FALSE)
;;;									(= local0 1)
									(= chutemoving 1)
								)
								(2
									(= newEvent (Event new:))
									(newEvent
									    type: evKEYBOARD
									    message: {enter chute}
									    modifiers: 999
									    claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
								)
								(3
									(= newEvent (Event new:))
									(newEvent
									    type: evKEYBOARD
									    message: {close chute door}
									    modifiers: 999
									    claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
									(User mapKeyToDir: TRUE)
;;;									(= local0 0)
									(= chutemoving 0)
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
				(if
					(and
						(ClickedOnObj chutefake (event x?) (event y?)) 
						(== local0 0)
					)
					(event claimed: TRUE)
					(switch theCursor	
						(998		
							(if local0
								(Print 44 10)
							else
								(DoLook {chute})
							)
						)
						(995
							(= chutes
								(Print
;;;									{Chute Actions}
;;;									#button {Open Door} 1
;;;									#button {Enter Chute} 2
;;;									#button {Close Door} 3		
									{Rampa}
									#button {Abrir Puerta} 1
									#button {Entrar} 2								
									#button {Cerrar Puerta} 3
								)
							)
							(switch chutes
								(1 ;Abrir Puerta
									(= newEvent (Event new:))
									(newEvent
									    type: evKEYBOARD
									    message: {open chute door}
									    modifiers: 999
									    claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
									(User mapKeyToDir: FALSE)
									(= local0 1)
									(= chutemoving 1)
								)
								(2
									(= newEvent (Event new:))
									(newEvent
									    type: evKEYBOARD
									    message: {enter chute}
									    modifiers: 999
									    claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
								)
								(3
									(= newEvent (Event new:))
									(newEvent
									    type: evKEYBOARD
									    message: {close chute door}
									    modifiers: 999
									    claimed: 0
									)
									(User handleEvent: newEvent)
									(newEvent dispose:)
									(User mapKeyToDir: TRUE)
									(= local0 0)
									(= chutemoving 0)
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
				(if (ClickedOnObj coffee (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine urn})
						)
						(995
							(DoVerb {Examine in coffee})	
						)
						(else
							(event claimed: FALSE)
						)
					)
				)							
				(if (ClickedOnObj chandelier (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {Examine chandelier})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)		
				(if (ClickedOnObj fire (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine log})
						)
						(995
							(DoVerb {get log})
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnObj gas (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoLook {lamp})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedOnObj Hutch (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine armoire})
						)
						(995
							(DoVerb {open armoire})
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if
					(and
						(ClickedOnObj BigTable (event x?) (event y?)) 
						(== (event claimed?) FALSE)
					)
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine nightstand dining})
						)					
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if
					(and
						(ClickedOnObj Table (event x?) (event y?)) 
						(== (event claimed?) FALSE)
					)
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {nightstand little})
						)					
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedInRect 0 10 139 154 event) ;exit room
					(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo -2 145)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if
					(and
						(ClickedOnObj Mirror (event x?) (event y?)) 
						(== (event claimed?) FALSE)
					)
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(= temp7
								(PrintSpecial
									{Espejo}
									#button {Examinar} 1
									#button {Mirar dentro} 2
									#button {Reflejo} 3
;;;									{Mirror}
;;;									#button {Examine} 1
;;;									#button {Examine below} 2							
;;;									#button {Reflexion} 3
								)
							)
							(switch temp7
								(1
								    (DoVerb {examine mirror})
								)
								(2
									(DoVerb {examine below mirror})
								)
								(3
									(DoVerb {examine in mirror})
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
		
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(= temp0
				(or
					(!= currentAct 1)
					(!= global154 3) ;gClarenceWilburState
					(and
						(not (Said 'ask[/c]/attorney<about>'))
						(not (Said 'ask[/attorney]/c<about>'))
					)
				)
			)
			(if
				(and
					global208
					temp0
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript 990)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((Said 'look')
							(if (& global175 $0002)
								(Print 34 2) ; "Even though you know where it is, you can't see it."
							else
								(Print 34 3) ; "You don't see one."
							)
						)
						((and (& global175 $0002) (Said 'open,move'))
							(if (not local2)
								(if (& (ego onControl: 1) $0008)
									(curRoom newRoom: 50)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 34 4) ; "Better not while someone is in the room."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 34 1) ; "This is a very elegant dining room. It looks like the Colonel has some class after all!"
						)
						((Said 'look/panel[<hidden]')
							(if (& global175 $0002)
								(Print 34 2) ; "Even though you know where it is, you can't see it."
							else
								(Print 34 3) ; "You don't see one."
							)
						)
						((Said '/wall,door')
							(Print 34 5) ; "You notice a small door below the wall light."
						)
						((Said '<below/nightstand')
							(Print 34 6) ; "There is nothing special under the table."
						)
						((Said '/nightstand')
							(Print 34 7) ; "Which table do you mean...the small table or the dining table?"
						)
						(
							(or
								(and (Said 'look/eye>') (Said 'look/man'))
								(Said 'look/eye[<man,painting]')
								(Said 'look/eye/man')
							)
							(Print 34 8) ; "The eyes of the man appear oddly vacant."
						)
						((Said '<behind,below/painting')
							(Print 34 9) ; "You can see nothing behind the picture."
						)
						((or (Said '/painting') (Said '/man/painting'))
							(Print 34 10) ; "Upon the wall opposite the fireplace hangs a picture of an aristocratic-looking, older man. That's strange...the eyes of the man appear oddly vacant."
						)
					)
				)
				((Said 'move,get/painting')
					(Print 34 11) ; "The portrait is firmly attached to the wall."
				)
				((Said 'get>')
					(cond
						((Said '/mirror')
							(Print 34 12) ; "The mirror is firmly attached to the wall."
						)
						((Said '/coffee')
							(Print 34 13) ; "The coffee urn is empty."
						)
						((Said '/fire,log')
							(Print 34 14) ; "Don't play with fire!"
						)
					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance chuteActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (cls))
			(1
;;;				(User canControl: FALSE)
				(ego illegalBits: 0 setMotion: MoveTo 33 127 self)
			)
			(2
				(ego view: 22 loop: 0 cel: 0 setCycle: EndLoop)
				(chute setMotion: MoveTo 19 167 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(3
				(= local0 1) ;chuteisopen
				(Print 34 20)
;;;				(User mapKeyToDir: FALSE)
;;;				(theGame setCursor: 998 (HaveMouse))
				(ego setMotion: 0)
				(User mapKeyToDir: FALSE)
				(theGame setCursor: 998 (HaveMouse))				
			)
			(4
				(chute setMotion: MoveTo 23 121)
				(= local0 0) ;chuteisnotopen
				(myMusic number: 75 loop: 1 play:)
				(ego setCycle: BegLoop self)
				(User mapKeyToDir: FALSE)
				(= chutemoving 0)
			)
			(5
				(ego view: 0 loop: 1 setCycle: Walk illegalBits: cWHITE)
;;;				(User canControl: TRUE)
				(User mapKeyToDir: TRUE)
				(theGame setCursor: 998 (HaveMouse))				
			)
			(6
				(myMusic number: 9 loop: 1 play:)
				(ego
					setLoop: 2
					cel: 0
					setMotion: MoveTo 27 128
					setCycle: EndLoop self
				)
			)
			(7
				(Print 34 21 #dispose)
				(= seconds 4)
			)
			(8
				(cls)
				(= global172 100)
				(ShakeScreen 10 5)
				(myMusic number: 47 loop: 1 play:)
				(= cycles 21)
			)
			(9
				(HandsOff)
				(= local1 1)
				(myMusic number: 57 loop: 1 play: self)
				(ego
					view: 38
					posn: 20 200
					setCycle: Walk
					setPri: 9
					illegalBits: 0
					setMotion: MoveTo 25 -1 self
				)
			)
			(10
				(= cIcon myIcon)
				(= deathLoop 0)
				(HandsOn)
;;;			)
;;;			(11
				(= cyclingIcon 1)
				(EgoDead 34 22)
			)
		)
	)
	
	(method (handleEvent event)
		(if (== (event type?) saidEvent)
			(cond 
				((event claimed?))
				((Said 'examine<(down,up)')
					(if local0
						(Print 34 15)
					else
						(event claimed: FALSE)
					)
				)
				((Said 'examine/chute')
					(if local0
						(Print 34 15)
					else
						(Print 34 16)
					)
				)
				((Said 'open/door[<chute]')
					(cond 
						(local0
							(Print 34 17)
						)
						((ego inRect: 5 126 40 135)
							(= state 0)
							(= cycles 1)
						)
						(else
							(NotClose)
						)
					)
				)
				((Said 'hop,crawl,go,enter/chute')
					(if local0
						(HandsOff)
						(= state 5)
						(= cycles 1)
					else
						(Print 34 18)
					)
				)
				((or (Said 'stand') (Said 'close/door,chute'))
					(if local0
						(= cycles 1)
					else
						(Print 34 19)
					)
				)
			)
		)
	)
)

(instance shadowWalk of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
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

(instance chair1 of RPicView
	(properties
		y 113
		x 106
		view 134
		loop 5
		cel 4
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 113
		x 136
		view 134
		loop 5
		cel 4
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair3 of RPicView
	(properties
		y 113
		x 164
		view 134
		loop 5
		cel 4
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair4 of RPicView
	(properties
		y 90
		x 205
		view 134
		loop 6
		cel 1
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair5 of RPicView
	(properties
		y 90
		x 50
		view 134
		loop 6
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair6 of RPicView
	(properties
		y 112
		x 188
		view 134
		loop 5
		cel 2
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair7 of RPicView
	(properties
		y 125
		x 220
		view 134
		loop 5
		priority 8
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair8 of RPicView
	(properties
		y 131
		x 87
		view 134
		loop 5
		cel 7
		priority 8
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair9 of RPicView
	(properties
		y 130
		x 121
		view 134
		loop 5
		cel 9
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair10 of RPicView
	(properties
		y 130
		x 153
		view 134
		loop 5
		cel 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair11 of RPicView
	(properties
		y 130
		x 181
		view 134
		loop 5
		cel 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance chair12 of RPicView
	(properties
		y 130
		x 212
		view 134
		loop 5
		cel 12
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance coffee of RPicView
	(properties
		y 138
		x 301
		view 134
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'open/coffee,urn[<urn]')
					(Said 'examine<in/coffee,urn')
					(Said 'pour,get,drink/cup,coffee')
				)
				(cond 
					((== currentAct 4)
						(Print 34 23)
					)
					((ego inRect: 259 139 320 200)
						(Print 34 13)
					)
					(else
						(NotClose)
					)
				)
			)
			((Said 'get/urn')
				(Print 34 24)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/urn'))
				(event claimed: TRUE)
				(Print 34 25)
			)
		)
	)
)

(instance chandelier of RPicView
	(properties
		y 42
		x 144
		view 134
		cel 3
		priority 9
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/chandelier'))
			(event claimed: TRUE)
			(Print 34 26)
		)
	)
)

(instance flowers of PicView
	(properties
		y 55
		x 129
		view 134
		cel 2
		priority 5
	)
)

(instance fire of Prop
	(properties
		y 85
		x 131
		view 232
		cel 1
		priority 5
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/log'))
			(event claimed: TRUE)
			(DoLook {fire})
		)
	)
)

(instance gas of Prop
	(properties
		y 82
		x 24
		view 134
		loop 3
		cel 1
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance chute of Actor
	(properties
		y 121
		x 23
		view 134
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/door'))
			(Print 34 5)
			(event claimed: TRUE)
		)
	)
)

(instance Shadow of Actor
	(properties
		view 110
	)
)

(instance Hutch of RFeature
	(properties
		nsTop 46
		nsLeft 222
		nsBottom 106
		nsRight 247
	)
	
	(method (handleEvent event)
		(cond 
			((or (Said 'examine<in/armoire') (Said 'open/armoire'))
				(Print 34 27)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(Print 34 28)
				(event claimed: TRUE)
			)
		)
	)
)

(instance BigTable of RFeature
	(properties
		nsTop 95
		nsLeft 99
		nsBottom 107
		nsRight 199
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine/nightstand<dining')
			)
			(Print 34 29)
			(event claimed: TRUE)
		)
	)
)

(instance Table of RFeature
	(properties
		nsTop 133
		nsLeft 284
		nsBottom 168
		nsRight 319
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said '/nightstand<little'))
			(Print 34 30)
			(event claimed: TRUE)
		)
	)
)

(instance Mirror of RFeature
	(properties
		nsTop 16
		nsLeft 107
		nsBottom 48
		nsRight 141
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<behind,below/mirror')
				(Print 34 31)
			)
			(
				(or
					(Said 'examine<in/mirror')
					(Said 'examine[<at]/reflection')
				)
				(if (< (ego distanceTo: fire) 80)
					(= theTalker talkLAURA)
					(Say 0 34 32)
				else
					(NotClose)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/mirror'))
				(Print 34 33)
				(event claimed: TRUE)
			)
		)
	)
)

(instance myMusic of Sound)

(instance myIcon of DCIcon
	(properties
		view 653
	)
)
(instance chutefake of Actor
	(properties
		y 125
		x 21
		view 950
		cel 0
		loop 6
	)
)