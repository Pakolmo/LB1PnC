;;; Sierra Script 1.0 - (do not remove this comment)
(script# 47)
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
	Room47 0
)
(synonyms
	(stair downstair upstair)
	(room hall)
	(armoire armoire)
	(balcony balcony banister)
)

(local
	local0
	LdoorIsOpen
	local2
	local3
	local4
	local5
	local6
)
(instance Room47 of Room
	(properties
		picture 47
	)
	
	(method (init)
		(super init:)
		(= currentPalette 0)
		(= south 37)
		(= north 43)
		(= horizon 100)
		(addToPics
			add:
				cabL
				cabR
				cat
				vase
				post1
				post2
				chain2
				chain3
				table1
				table2
				wardR
				wardL
			eachElementDo: #init
			doit:
		)
		(self
			setRegions: 211
			setFeatures: Stair table1 table2 wardL wardR Rail
		)
		(LoadMany VIEW 9 38 651)
		(LoadMany SOUND 38 43 44 47 57 87 109)
		(if (and global177 (not (Btst fSawShadowyFigure)))
			(= local5 1)
			(ego loop: 2)
			(Load PICTURE 11)
			(Load VIEW 507)
		)
		(if howFast
			(chand setPri: 15 init: stopUpd: setScript: jiggle)
			(lampL setPri: 8 setCycle: Forward init:)
			(lampR setPri: 8 setCycle: Forward init:)
			(lamp3 setPri: 15 setCycle: Forward ignoreActors: TRUE init:)
			(lamp4 setPri: 15 setCycle: Forward ignoreActors: TRUE init:)
		else
			(chand setPri: 15 init: stopUpd:)
			(lampL setPri: 8 init: stopUpd:)
			(lampR setPri: 8 init: stopUpd:)
			(lamp3 setPri: 15 ignoreActors: TRUE init: stopUpd:)
			(lamp4 setPri: 15 ignoreActors: TRUE init: stopUpd:)
		)
		(Ldoor init: stopUpd:)
		(rail1 setPri: 11 ignoreActors: TRUE init: stopUpd:)
		(rail2 setPri: 11 ignoreActors: TRUE init: stopUpd:)
		(if (and (== currentAct 1) (not (ego has: iHandkerchief)))
			(Load VIEW 17)
			(hanky init:)
		)
		(switch prevRoomNum
			(48 (ego posn: 228 106))
			(46 (ego posn: 105 109))
			(43
				(cond 
					((< (ego x?) 99) (ego posn: 110 105))
					((> (ego x?) 222) (ego posn: 205 105))
					(else (ego posn: (ego x?) 105))
				)
			)
			(74
				(ego setPri: 9 posn: 254 114 setMotion: MoveTo 258 131)
			)
			(37
				(= local3 1)
				(if (< (ego x?) 160)
					(ego posn: 39 188 setMotion: MoveTo 60 139)
				else
					(ego posn: 280 188 setMotion: MoveTo 261 136)
				)
			)
		)
		(ego view: 0 illegalBits: cWHITE init:)
	)
	
	(method (doit &tmp temp0)
		(if (FirstEntry)
			(Print 47 0)
		)
		(if (and global216 (== local5 1))
			(= local5 2)
			(self setScript: (ScriptID 408 0))
		)
		(if (and (== local5 2) (Btst fSawShadowyFigure))
			(= local5 0)
			(addToPics
				add:
					cabL
					cabR
					cat
					vase
					post1
					post2
					chain2
					chain3
					table1
					table2
					wardR
					wardL
				eachElementDo: #init
				doit:
			)
			(self setFeatures: Stair table1 table2 wardL wardR Rail)
			(cast eachElementDo: #show)
		)
		(if (not local4)
			(if
				(or
					(& (ego onControl: FALSE) cCYAN)
					(& (ego onControl: FALSE) cRED)
				)
				(= temp0 9)
			else
				(= temp0 -1)
			)
			(ego setPri: temp0)
		)
		(switch (ego onControl: origin)
			(cGREEN (curRoom newRoom: 46))
			(cBLUE (curRoom newRoom: 48))
			(cRED
				(if (== (ego loop?) 3) (curRoom newRoom: 74))
			)
			(2048
				(if (not local3)
					(= local3 1)
					(ego setMotion: MoveTo 39 190)
				)
			)
			(4096
				(if (not local3)
					(= local3 1)
					(ego setMotion: MoveTo 280 190)
				)
			)
			(1
				(if local3
					(= local3 0)
				)
			)
			(128
				(if
					(and
						(== local2 0)
						(> (ego heading?) 134)
						(< (ego heading?) 226)
					)
					(= local2 1)
					(= north (= south 0))
					(if (< (ego x?) 160)
						(rail1 setScript: falling)
					else
						(rail2 setScript: falling)
					)
				)
			)
		)
		(if (< (ego y?) 145)
			(cond 
				((< (ego x?) 130) (= vertAngle 15))
				((< (ego x?) 190) (= vertAngle 0))
				(else (= vertAngle 160))
			)
		else
			(= vertAngle 0)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(switch (event type?)
			(saidEvent
				(cond 
					((Said 'examine<down[/!*]') (Print 47 1))
					((Said 'examine>')
						(cond 
							((Said '[<around,at,down][/room]') (Print 47 0))
							((Said '/door<hidden') (Print 47 2))
							((or (Said '/door<bathroom') (Said '/bathroom'))
								(Print 47 3)
							)
							((Said '/bird,post[<newel]') (Print 47 4))
							((Said '/curtain') (Print 47 5))
						)
					)
					(
					(Said 'get,force,rotate,detach/bird,post[<newel]') (Print 47 6))
					((Said '*/armoire') (NotClose))
				)
			)
			(mouseDown
				(if
					(or
						(== (User controls?) 0)
						(& (ego onControl: 0) cBLACK)
						(& (ego onControl: 0) cCYAN)
						(& (ego onControl: 0) cLGREY)
					)
					(return)
				)
				(switch (ego onControl: 0)
					(cLBLUE
						(ego
							setMotion:
								MoveTo
								(cond 
									((< (event y?) (ego y?)) 60)
									((> (event y?) (ego y?)) 39)
								)
								(cond 
									((< (event y?) (ego y?)) 136)
									((> (event y?) (ego y?)) 190)
								)
						)
					)
					(cLGREEN
						(ego
							setMotion:
								MoveTo
								(cond 
									((< (event y?) (ego y?)) 261)
									((> (event y?) (ego y?)) 280)
								)
								(cond 
									((< (event y?) (ego y?)) 136)
									((> (event y?) (ego y?)) 190)
								)
						)
					)
				)
				(event claimed: TRUE)
			)
			(direction
				(if
					(or
						(== (User controls?) 0)
						(& (ego onControl: 0) cBLACK)
						(& (ego onControl: 0) cCYAN)
						(& (ego onControl: 0) cMAGENTA)
						(& (ego onControl: 0) cLGREY)
					)
					(return)
				)
				(switch (event message?)
					(dirN
						(switch (ego onControl: 0)
							(cLBLUE
								(ego setMotion: MoveTo 60 136)
							)
							(cLGREEN
								(ego setMotion: MoveTo 261 136)
							)
						)
						(event claimed: TRUE)
					)
					(dirS
						(switch (ego onControl: 0)
							(cLBLUE
								(ego setMotion: MoveTo 39 190)
							)
							(cLGREEN
								(ego setMotion: MoveTo 280 190)
							)
						)
						(event claimed: TRUE)
					)
					(else 
						(event claimed: TRUE)
						(return)
					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(if (and (!= n 46) (or (== global177 1) (== global177 3)))
			(= global177 2)
		)
		(super newRoom: n)
	)
)

(instance myDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (ego x?) 86) (== (ego y?) 131))
					(= cycles 1)
				else
					(ego setMotion: MoveTo 86 131 self)
				)
			)
			(1
				(Face ego Ldoor)
				(Ldoor ignoreActors: TRUE cycleSpeed: 2 setCycle: EndLoop self)
				(myMusic number: 43 loop: 1 play:)
			)
			(2
				(ego setMotion: MoveTo 66 131 self)
			)
			(3
				(ego loop: 3)
				(= LdoorIsOpen 1)
				(if
					(and
						(> currentAct 0)
						(< currentAct 7)
						(< (Random 1 100) 25)
					)
					(= state 6)
				)
				(= seconds 2)
			)
			(4
				(Print 47 7)
				(ego setMotion: MoveTo 86 131 self)
			)
			(5
				(ego loop: 1)
				(Ldoor ignoreActors: 0 cycleSpeed: 2 setCycle: BegLoop self)
				(myMusic number: 44 loop: 1 play:)
				(= LdoorIsOpen 0)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
			(7
				(hand setCycle: EndLoop self init:)
				(myMusic number: 87 loop: 1 play:)
				(ego hide:)
			)
			(8
				(myIcon view: 651 cycler: EndLoop)
				(= cIcon myIcon)
				(= deathLoop 0)
				(= deathCel 0)
				(= cyclingIcon 1)
				(EgoDead 47 8)
			)
		)
	)
)

(instance jiggle of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not local5) (< (Random 1 100) 10) (== local4 0))
					(= cycles 1)
				else
					(= state -1)
					(= seconds 5)
				)
			)
			(1
				(if (not local6)
					(= local6 1)
					(myMusic number: 109 loop: 1 play:)
				)
				(chand posn: 162 87 forceUpd:)
				(= cycles 2)
			)
			(2
				(chand posn: 161 87 forceUpd:)
				(= cycles 2)
			)
			(3
				(chand posn: 162 87 forceUpd:)
				(= cycles 2)
			)
			(4
				(chand posn: 161 87)
				(if (== (++ local0) 3)
					(chand stopUpd:)
					(= local6 0)
					(= local0 0)
					(= state -1)
				else
					(= state 0)
				)
				(= cycles 2)
			)
		)
	)
)

(instance falling of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local4 1)
				(Print 47 9)
				(ego view: 9 setLoop: 0 setCycle: EndLoop self)
			)
			(1
				(myMusic number: 38 loop: 1 play:)
				(ego setLoop: 1 setCycle: Forward)
				(client view: 9 cel: 0 setLoop: 3 setCycle: EndLoop self)
			)
			(2
				(client
					illegalBits: 0
					setStep: 12 12
					setMotion: MoveTo (client x?) 250
				)
				(ego
					setLoop: 2
					setPri: 15
					setCycle: EndLoop self
					illegalBits: 0
				)
			)
			(3
				(ego
					setCel: 9
					setCycle: 0
					setStep: 10 10
					setMotion: MoveTo (ego x?) 250 self
				)
			)
			(4
				(myMusic stop:)
				(myMusic number: 47 loop: 1 play:)
				(= cycles 2)
			)
			(5
				(ShakeScreen 10 5)
				(= seconds 3)
			)
			(6
				(myMusic number: 57 loop: 1 play: self)
				(ego
					view: 38
					setCel: -1
					setLoop: 0
					setPri: 15
					setCycle: Forward
					setStep: 3 3
					ignoreActors: TRUE
					illegalBits: 0
					ignoreHorizon: TRUE
					setMotion: MoveTo (ego x?) -50 self
				)
			)
			(7
				(= cIcon myIcon)
				(= deathLoop 0)
				(= deathCel 0)
				(= cyclingIcon 1)
			)
			(8 (EgoDead 47 10))
		)
	)
)

(instance post1 of PicView
	(properties
		y 122
		x 78
		view 147
		loop 2
		priority 15
		signal ignrAct
	)
)

(instance post2 of PicView
	(properties
		y 121
		x 243
		view 147
		loop 2
		cel 1
		priority 15
		signal ignrAct
	)
)

(instance cabL of PicView
	(properties
		y 53
		x 124
		view 147
		loop 2
		cel 8
		priority 2
	)
)

(instance cabR of PicView
	(properties
		y 53
		x 199
		view 147
		loop 2
		cel 9
		priority 2
	)
)

(instance cat of PicView
	(properties
		y 53
		x 143
		view 147
		loop 2
		cel 6
		priority 2
	)
)

(instance vase of PicView
	(properties
		y 52
		x 177
		view 147
		loop 2
		cel 7
		priority 1
	)
)

(instance wardR of RPicView
	(properties
		y 80
		x 220
		view 147
		loop 2
		cel 5
		priority 4
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/armoire'))
			(event claimed: TRUE)
			(Print 47 11)
		)
	)
)

(instance wardL of RPicView
	(properties
		y 80
		x 103
		view 147
		loop 2
		cel 4
		priority 4
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/armoire'))
			(event claimed: TRUE)
			(Print 47 11)
		)
	)
)

(instance chain2 of PicView
	(properties
		y 47
		x 162
		view 147
		loop 2
		cel 3
		priority 15
	)
)

(instance chain3 of PicView
	(properties
		y 65
		x 162
		view 147
		loop 2
		cel 3
		priority 15
	)
)

(instance table1 of RPicView
	(properties
		y 94
		x 101
		view 147
		loop 2
		cel 10
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
		y 94
		x 221
		view 147
		loop 2
		cel 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance chand of Prop
	(properties
		y 87
		x 161
		view 147
		loop 2
		cel 2
	)
	
	(method (handleEvent event)
		(if (not local5)
			(cond 
				((Said 'get/chandelier')
					(Print 47 12)
				)
				(
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/chandelier,ceiling')
						(Said 'examine<up')
					)
					(event claimed: TRUE)
					(Print 47 13)
				)
			)
		)
	)
)

(instance Ldoor of Prop
	(properties
		y 129
		x 53
		view 147
		loop 3
	)
	
	(method (handleEvent event)
		(if (not local5)
			(cond 
				((Said 'close/door') (AlreadyClosed))
				((Said 'bang/door,closet') (Print 47 14))
				((Said 'open,(examine<in)/door,closet')
					(cond 
						(LdoorIsOpen (AlreadyOpen))
						((& (ego onControl: 0) cMAGENTA)
							(self setScript: myDoor)
						)
						(else (NotClose))
					)
				)
				(
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/closet,(door<closet),(door[<!*])')
					)
					(event claimed: TRUE)
					(Print 47 15)
				)
			)
		)
	)
)

(instance rail1 of Actor
	(properties
		y 141
		x 115
		view 147
		loop 2
		cel 13
	)
)

(instance rail2 of Actor
	(properties
		y 141
		x 208
		view 147
		loop 2
		cel 14
	)
)

(instance lampL of Prop
	(properties
		y 82
		x 89
		view 147
		cel 1
	)
	
	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event shiftDown))
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lampR of Prop
	(properties
		y 82
		x 234
		view 147
		loop 1
	)
	
	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event shiftDown))
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp3 of Prop
	(properties
		y 177
		x 234
		view 147
		loop 1
	)
	
	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event shiftDown))
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp4 of Prop
	(properties
		y 177
		x 88
		view 147
		cel 1
	)
	
	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event shiftDown))
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance hand of Prop
	(properties
		y 130
		x 66
		view 18
	)
)

(instance hanky of Prop
	(properties
		y 108
		x 103
		view 147
		loop 2
		cel 12
	)
	
	(method (handleEvent event)
		(if (not local5)
			(cond 
				(
					(or
						(MousedOn self event shiftDown)
						(Said 'examine/handkerchief,dirt')
						(and (< (ego y?) 128) (Said 'examine<down[/!*]'))
					)
					(event claimed: TRUE)
					(Print 47 16)
				)
				((Said 'get/handkerchief[/dirt]')
					(if (< (ego distanceTo: hanky) 20)
						(self setScript: pickUp)
					else
						(NotClose)
					)
				)
			)
		)
	)
)

(instance pickUp of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face ego hanky)
				(= cycles 2)
			)
			(1
				(ego view: 17 cel: 0 setMotion: 0 setCycle: EndLoop self)
			)
			(2
				(Ok)
				(hanky hide:)
				(= gotItem 1)
				(ego get: 23)
				(= cycles 2)
			)
			(3 (ego setCycle: BegLoop self))
			(4
				(HandsOn)
				(ego view: 0 setCycle: Walk)
				(client dispose: delete: setScript: 0)
			)
		)
	)
)

(instance Rail of RFeature
	(properties
		nsTop 120
		nsLeft 79
		nsBottom 143
		nsRight 241
	)
	
	(method (handleEvent event)
		(if
		(or (MousedOn self event 3) (Said 'examine/balcony'))
			(Print 47 17)
			(event claimed: TRUE)
		)
	)
)

(instance Stair of RFeature
	(properties
		nsTop 63
		nsLeft 244
		nsBottom 120
		nsRight 269
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 47 18)
			(event claimed: TRUE)
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 653
	)
	
	(method (init)
		((= cycler (Forward new:)) init: self)
	)
)
