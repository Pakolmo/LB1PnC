;;; Sierra Script 1.0 - (do not remove this comment)
(script# 3)
(include game.sh)
(use Main)
(use Intrface)
(use DCIcon)
(use RFeature)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room3 0
)

(local
	nearLadder
	local1
	local2
	climbingUp
	local4
	temp7
	moving
)
(procedure (RoomPrint)
	(Print &rest 67 110 25 30 1 88)
;;;		#at 110 25
;;;		#mode teJustCenter
;;;		#dispose
;;;	)
)

(instance Room3 of Room
	(properties
		picture 3
	)
	
	(method (init)
		(= south 14)
		(= west 9)
		(= east 10)
		(super init:)
		(Load VIEW 34)
		(Load SOUND 73)
		(if (ego has: iCane)
			(LoadMany VIEW 31 32 53)
			(LoadMany SOUND 30 42)
		)
		(Load SOUND 17)
		(if (and (== currentAct 1) (<= global155 13))
			(self setRegions: 381)
		)
		(if howFast
			(cloud1 init: stopUpd: setScript: showers)
			(cloud2 init: stopUpd:)
		)
		(soundFX number: 17 loop: 0)
		(bat setLoop: 4 xStep: 8 illegalBits: 0 init: hide:)
		(if bellOnGround
			(bell
				illegalBits: 0
				setLoop: (if (== ((inventory at: iCrank) owner?) 3) 0 else 6)
				posn: 72 138
			)
		else
			(bell illegalBits: 0 setLoop: 0)
		)
		(bell setPri: 11 baseSetter: bellBase init: stopUpd:)
		(ring setLoop: 1 setPri: 11 init: stopUpd:)
		(arm setPri: 14 init: hide:)
		(self setFeatures: Ladder)
		(if
			(and
				(>= currentAct 2)
				(< currentAct 4)
				(< [global368 1] 700)
			)
			(self setRegions: 202)
		)
		(if
			(or
				(and (== currentAct 3) (< global114 2))
				(and (== currentAct 6) (not (& global118 $0002)))
			)
			(self setRegions: 281)
		)
		(switch prevRoomNum
			(10 (ego posn: 318 175))
			(14 (ego posn: 305 187))
			(9 (ego posn: 1 176))
		)
		(ego view: 0 illegalBits: cWHITE init:)
	)
	
;;;	(method (doit)
	(method (doit)
		(if (FirstEntry)
			(Print 3 0)
		)
		(if (and (not climbingUp) (& (ego onControl: 0) $0002))
			(= climbingUp TRUE)
			(ego setScript: climbUp)
		)
	
		
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)

			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					(if (ClickedInRect 8 314 184 189 event) ;exit room down
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
					(if (ClickedInRect 0 5 155 189 event) ;exit room left
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
					(if (ClickedInRect 315 319 147 189 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999

							(ego setMotion: MoveTo (+ (ego x?) 315) (ego y?) )
;;;							
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)												
				(if (and (ClickedOnObj bell (event x?) (event y?)) 
					(== moving 1))
					
;;;					(ego setMotion: 0)
;;;					(if (== theCursor 999) ;
;;;						(event claimed: TRUE)
;;;						(DoVerb {climb})
;;;						(= moving 0)
;;;						(ego setScript: climbDown)
;;;					)
					
					(event claimed: TRUE)
					(switch theCursor
;;;					(999
;;;;;;						(= moving 0)
;;;						(DoVerb {climb})
;;;;;;						(= moving 0)
;;;					)

					(611 ;oilcan_
						(DoVerb {oil bell})	;YES					
					)

						
						(612
							(DoVerb {ring with cane bell})	
						)
						(998
								(= temp7
												(Print
		
													{Bell}
													#button {examine} 1
													#button {examine in} 2								
													
												)
											)
											(switch temp7
												(1 
													(DoVerb {examine bell})
														
												)
												(2 
													(DoVerb {examine in bell})
														
												)
																							
												(else
													(event claimed: FALSE)
											)																	
											)
						)

						(995
							(= temp7
												(PrintSpecial
		
													{Bell}
													#button {get control} 1
													#button {move} 2								
													#button {get} 3
													#button {ring} 4
												)
											)
											(switch temp7
												(1 
													(DoVerb {get control})
														
												)
												(2 
													(DoVerb {move bell})
														
												)
												(3 
													(DoVerb {get bell})
														
												)	
												(4 
													(DoVerb {ring bell})
														
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
		
		
				(if (and (ClickedOnObj bell (event x?) (event y?)) 
						(== bellOnGround 1))
					
					(event claimed: TRUE)
					(switch theCursor
					(998
						(DoVerb {look bell})
					)
					(995
						(DoVerb {Get crank})
					)
					(else
							(event claimed: FALSE)
						)
					)
					)
				
		
		
		
		
						(if (ClickedOnObj ring (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
							(DoVerb {examine ring})
						)
					(612 ;cane!

							(DoVerb {ring bell with cane})
						

					)						

						(else
							(event claimed: FALSE)
						)																	
						)
					)	
		
				(if (ClickedOnObj bat (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {capture bat})
						)
						(998
							(DoVerb {examine bat})
						)
						(else
							(event claimed: FALSE)
						)																	
						)
					)	
			
				(if (ClickedOnObj Ladder (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setScript: climbDown)
						)
						(995
							(DoVerb {climb ladder})
						)
						(998
							(DoVerb {examine ladder})
						)
						(else
							(event claimed: FALSE)
						)																	
						)
					)	
					
		
				)
			)
		
		
		
		(DisposeScript SAVE)
		(super handleEvent: event)
		(if (event claimed?) (return TRUE))
		(return
			(switch (event type?)
				(saidEvent
					(cond 
						((Said 'examine>')
							(cond 
								((Said '[<around,at][/room]')
									(if bellOnGround
										(Print 3 1)
									else
										(Print 3 0)
									)
								)
								((Said '<up')
									(if (& (ego onControl: 1) $0004)
										(if bellOnGround
											(Print 3 2)
										else
											(Print 3 3)
										)
									else
										(event claimed: FALSE)
									)
								)
								((Said '/path')
									(Print 3 4)
								)
								((Said '/field')
									(Print 3 5)
								)
								((Said '/fence')
									(Print 3 6)
								)
								((Said '/archway')
									(Print 3 7)
								)
								((or (Said '<(at,in)/tower') (Said '<in'))
									(cond 
										(nearLadder
											(if bellOnGround
												(SeeNothing)
											else
												(Print 3 8)
											)
										)
										((& (ego onControl: 1) $0004)
											(if bellOnGround
												(Print 3 2)
											else
												(Print 3 3)
											)
										)
										(else
											(Print 3 9)
										)
									)
								)
								((Said '/tower[<bell]')
									(if bellOnGround
										(Print 3 1)
									else
										(Print 3 10)
									)
								)
							)
						)
						((Said 'climb/fence')
							(Print 3 11)
						)
						(
							(or
								(Said 'use/can<oil')
								(Said 'oil/bell')
								(Said 'attach/oil/bell')
							)
							(if (== oiledBell FALSE)
								(if (ego has: iOilcan)
									(if nearLadder
										(= oiledBell TRUE)
										(self setScript: oilBell)
									else
										(Print 3 12)
									)
								else
									(Print 3 13)
								)
							else
								(Print 3 14)
							)
						)
					)
				)
				(mouseDown ;FIXED laura movements.
;;;					(if
;;;						(and
;;;							nearLadder
;;;							(> (event y?) (ego y?))
;;;;;;							(not (& (event modifiers?) (| shiftDown ctrlDown altDown)))
;;;							(not (& (event modifiers?) $000f))
;;;							(User canInput?)
;;;						)
;;;						(ego setScript: climbDown)
;;;					)
				)
				(direction
					(if
						(and
							nearLadder
;;;							(== (event message?) dirS)
							(== (event message?) JOY_DOWN)
							(User canInput?)
						)
						(ego setScript: climbDown)
					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance bellBase of Code
	
	(method (doit)
		(bell
			brTop: (+ (bell y?) 8)
			brLeft: (- (bell x?) 2)
			brBottom: (+ (bell y?) 12)
			brRight: (+ (bell x?) 2)
		)
	)
)

(instance showers of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (= state 3)))
			(1
				(cloud1 setCycle: Forward)
				(cloud2 setCycle: Forward)
				(= cycles 7)
			)
			(2
				(cloud1 setCycle: EndLoop)
				(cloud2 setCycle: EndLoop self)
			)
			(3
				(soundFX number: 17 play: self)
			)
			(4
				(if (< (Random 1 100) 25)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance climbUp of Script
	
;;;	(method (doit event)
;;;	(theGame setCursor: 998 (HaveMouse))
;;;		(if (== moving 1)
;;;				
;;;				(if (== theCursor 999)
;;;;;;				(SetCursor 998)
;;;;;;				(theGame setCursor: 998 (HaveMouse))
;;;;;;					(event claimed: TRUE)
;;;					(ego setMotion: 0)
;;;					(switch theCursor
;;;						(999
;;;;;;							(ego setMotion: 0)
;;;;;;							(theGame setCursor: 998 (HaveMouse))
;;;							(DoVerb {climb})
;;;;;;							(climbDown setScript: 0)
;;;							(= moving 0)
;;;						)
;;;						(else
;;;;;;								(ego setMotion: 0)
;;;						)
;;;					 
;;;					)
;;;	)
;;;		)
;;;	)
;;;				
	(method (doit event)
		
					(if (== theCursor 999) ;
						(ego setMotion: 0)
						(= nearLadder 1)
;;;							(event claimed: TRUE)
;;;							(DoVerb {climb})
;;;							(= moving 0)

					)
					)




	
		
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= climbingUp TRUE)
				(HandsOff)
				(ego
					illegalBits: 0
					setLoop: (ego loop?)
					setMotion: MoveTo 26 156 self
				)
			)
			(1
				(ego
					view: 34
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setPri: 12
					setCycle: EndLoop self
				)
			)
			(2
				(ego posn: 26 145 setLoop: 1 cel: 0 setCycle: EndLoop self)
			)
			(3
				(ego posn: 26 120 cel: 0 setCycle: EndLoop self)
			)
			(4
				(ego setLoop: 2 posn: 26 110 cel: 0 setCycle: EndLoop self)
			)
			(5
				(ego setLoop: 3 cel: 0 posn: 39 55 setCycle: EndLoop self)
				(HandsOn)
				(User mapKeyToDir: FALSE)
				(ego setMotion: 0)
				
				(if (not local4)
					(++ local4)
					(bat show: setCycle: Walk setMotion: MoveTo 340 80)
				)
				(theGame setCursor: 998 (HaveMouse))
				(= moving 1)
			)
			(6
				(arm show:)
				(ego loop: 8 stopUpd: 0)
				(= cycles 1)
			)
			(7
				(= nearLadder 1)
				(User canInput: TRUE)
				(HandsOn)
				(User mapKeyToDir: FALSE)
				(= moving 1)
				(client setScript: 0)
			)
		)
	)
)

(instance climbDown of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= nearLadder 0)
				(User canInput: FALSE)
				(ego cel: 3 loop: 3 setCycle: BegLoop self)
				(arm hide:)
			)
			(1
				(ego setLoop: 2 posn: 26 110 cel: 3 setCycle: BegLoop self)
			)
			(2
				(ego setLoop: 1 posn: 26 120 cel: 3 setCycle: BegLoop self)
			)
			(3
				(ego posn: 26 145 cel: 3 setCycle: BegLoop self)
			)
			(4
				(ego setLoop: 0 posn: 26 156 cel: 3 setCycle: BegLoop self)
			)
			(5
				(ego
					view: 0
					posn: 26 158
					setPri: -1
					setCycle: Walk
					setLoop: 2
;;;					illegalBits: cWHITE
					illegalBits: -32768
					cycleSpeed: 0
					setMotion: MoveTo 32 164 self
				)
			)
			(6
				(ego setLoop: -1)
				(HandsOn)
				(= moving 0)
				(= local1 (= nearLadder (= climbingUp 0)))
				(client setScript: 0)
			)
		)
	)
)


(instance oilBell of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(arm setLoop: 6)
				(arm cel: (- (NumCels arm) 1) setCycle: BegLoop self)
			)
			(1
				(soundFX number: 73 loop: 1 play:)
				(arm setLoop: 7 setCycle: Forward)
				(= cycles 16)
			)
			(2
				(soundFX stop:)
				(arm setLoop: 6 cel: 0 setCycle: EndLoop self)
			)
			(3
				(Print 3 15)
				(User canInput: TRUE)
				(client setScript: 0)
			)
		)
	)
)

(instance ringBell of Script

	(method (doit)
		(super doit:)
		(if
			(and
				(< (ego distanceTo: bell) 75)
				(!= (ego view?) 31)
				local2
			)
			(ego
				view: 31
				setLoop: 0
				cel: 0
				cycleSpeed: 0
				setCycle: EndLoop
			)
		)
		(if (and (== (ego view?) 31) (== (ego cel?) 3))
			(ego setMotion: MoveTo 73 148)
			(bell hide:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
;;;				(if (& (ego onControl: origin) cCYAN)
				(if (& (ego onControl: 1) $0008)
					(ego setMotion: MoveTo 94 144 self)
					(= local2 0)
				else
					(ego illegalBits: 0 setMotion: MoveTo 73 144 self)
					(= local2 1)
				)
			)
			(1
				(ego
					view: 53
					cel: 0
					loop: (if local2 4 else 0)
					setCycle: EndLoop
				)
				(RoomPrint 3 16)
				(= seconds 3)
			)
			(2
				(cls)
				(if oiledBell
					(ego
						loop: (if local2 5 else 2)
						cycleSpeed: 2
						setCycle: Forward
					)
					(bell setCycle: Forward)
					(ring startUpd: setCycle: Forward)
					(soundFX number: 30 loop: 1 play:)
					(= cycles 8)
				else
					(RoomPrint (= state 3) 17)
					(= seconds 4)
				)
			)
			(3
				(cls)
				(bell
					view: 203
					setLoop: 0
					setCel: 0
					cycleSpeed: 0
					yStep: 10
				)
				(ring setCycle: BegLoop)
				(if (and oiledBell local2)
					(bell setMotion: MoveTo 66 108 self)
					(RoomPrint 3 18)
				else
					(= bellOnGround 1)
					(bell
						setLoop: 6
						ignoreActors: 1
						setMotion: MoveTo 72 138 self
					)
					(ego setCycle: 0)
					(RoomPrint 3 19)
				)
			)
			(4
				(cls)
				(if (and oiledBell local2)
					(soundFX number: 42 play:)
					(ShakeScreen 5 1)
					(if (< (Random 1 100) 6) (= state 5) else (= state 8))
					(= cycles 14)
				else
					(if (== bellOnGround 1)
						(soundFX number: 30 play:)
						(ShakeScreen 5 1)
					)
					(ego loop: (if local2 4 else 0))
					(ego cel: (- (NumCels ego) 1) setCycle: BegLoop self)
				)
			)
			(5
				(ego
					view: 0
					loop: (if oiledBell 1 else 2)
					cycleSpeed: 0
;;;					illegalBits: cWHITE
					illegalBits: -32768
					setCycle: Walk
				)
				(ring stopUpd:)
				(if oiledBell
					(bell ignoreActors: FALSE stopUpd:)
					(Print 3 20)
				)
				(HandsOn)
				(client setScript: 0)
			)
			(6
				(= local2 0)
				(ego
					view: 32
					setLoop: -1
					setCycle: Walk
					setAvoider: (Avoider new:)
;;;					illegalBits: cWHITE
					illegalBits: -32768
					setMotion: MoveTo 179 167 self
				)
			)
			(7
				(soundFX number: 30 play:)
				(ShakeScreen 5 shakeSRight)
				(ego setLoop: 5 setMotion: MoveTo 159 167 self)
			)
			(8
				(ego loop: 4)
				(= seconds 7)
			)
			(9
				(= cIcon myIcon)
				(= deathLoop 2)
				(= deathCel 0)
				(EgoDead 3 21)
			)
		)
	)
)

(instance pullRope of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego illegalBits: 0 setMotion: MoveTo 85 146 self)
			)
			(1
				(ego
					view: 58
					cel: 0
					loop: 0
					cycleSpeed: 1
					setCycle: EndLoop self
				)
				(RoomPrint 3 22)
			)
			(2
				(ego loop: 2 setCycle: Forward)
				(= seconds 3)
			)
			(3
				(ego loop: 0 cel: 5 setCycle: BegLoop)
				(= seconds 3)
			)
			(4
				(cls)
				(Print 3 23)
				(ego
					view: 0
					loop: 1
					cycleSpeed: 0
					illegalBits: cWHITE
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(DirLoop ego (GetAngle (ego x?) (ego y?) 72 150))
				(= cycles 2)
			)
			(1
				(ego view: 17 cel: 0 setMotion: 0 setCycle: EndLoop self)
			)
			(2
				(= gotItem TRUE)
				(Print 3 24)
				(ego get: iCrank)
				(bell setLoop: 0 forceUpd:)
				(= cycles 2)
			)
			(3 (ego setCycle: BegLoop self))
			(4
				(HandsOn)
				(ego view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 17
		priority 3
	)
)

(instance bell of Actor
	(properties
		y 12
		x 72
		view 203
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<(in,below)/bell')
				(if bellOnGround
					(Print 3 25)
				else
					(Print 3 26)
				)
			)
			((Said 'get/control')
				(if bellOnGround
					(cond 
						((!= ((inventory at: iCrank) owner?) 3)
							(AlreadyTook)
						)
						((< (ego distanceTo: bell) 15)
							(self setScript: pickUp)
						)
						(else
							(NotClose)
						)
					)
				else
					(Print 3 27)
				)
			)
			((Said 'get,move/bell')
				(Print 3 28)
			)
			(
				(or
					(Said '(ring,drag)<use<cane/(hemp,ring,bell)')
					(Said 'use/cane/bell<ring')
					(Said 'drag,get,get/(ring,hemp,bell)/cane<(with,use)')
					(Said 'ring/bell/cane<(with,use)')
				)
				(if (not bellOnGround)
;;;					(if oiledBell
					(if (ego has: iCane)
						(if
							(or
;;;								(& (ego onControl: origin) cCYAN)
;;;								(& (ego onControl: origin) cGREEN)
								(& (ego onControl: 1) $0008)
								(& (ego onControl: 1) $0004)
							)
							(ego setScript: ringBell)
						else
							(NotClose)
						)
					else
;;;						(DontHave)
;;;					)
					)
				else
					(Print 3 29)
				)
			)
			(
				(or
					(Said '(ring,drag)<use<*/(hemp,ring,bell)')
					(Said 'use/*/bell<ring')
					(Said 'drag/(ring,hemp)/*<with')
				)
				(Print 3 30)
			)
			((Said 'ring/bell')
				(if bellOnGround
					(Print 3 29)
				else
					(Print 3 31)
				)
			)
			((Said 'get,get,drag,ring/bell,hemp,ring')
				(cond 
					(bellOnGround
						(Print 3 29)
					)
					(oiledBell
						(or
;;;							(& (ego onControl: origin) cCYAN)
;;;							(& (ego onControl: origin) cGREEN)
							(& (ego onControl: 1) $0008)
							(& (ego onControl: 1) $0004)
						)
						(ego setScript: pullRope)
					)
					(else
						(NotClose)
					)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'search,examine/bell')
				)
				(event claimed: TRUE)
				(cond 
					(bellOnGround
						(if (== ((inventory at: iCrank) owner?) 3)
							(Print 3 32)
						else
							(Print 3 33)
						)
					)
					(oiledBell
						(Print 3 15)
					)
					(else
						(Print 3 34)
					)
				)
			)
		)
	)
)

(instance ring of Prop
	(properties
		y 82
		x 77
		view 203
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/hemp,ring'))
			(event claimed: TRUE)
			(Print 3 35)
		)
	)
)

(instance arm of Prop
	(properties
		y 28
		x 46
		view 34
		loop 4
		cycleSpeed 2
	)
)

(instance cloud1 of Prop
	(properties
		y 54
		x 277
		view 203
		loop 2
		cel 1
	)
)

(instance cloud2 of Prop
	(properties
		y 57
		x 211
		view 203
		loop 3
		cel 1
	)
)

(instance bat of Actor
	(properties
		y 14
		x 74
		view 203
		loop 4
	)
	
	(method (handleEvent event)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/bat'))
				(event claimed: TRUE)
				(Print 3 36)
			)
			((Said 'capture,get/bat')
				(Print 3 37)
			)
		)
	)
)

(instance Ladder of RFeature
	(properties
		nsTop 46
		nsLeft 28
		nsBottom 156
		nsRight 37
	)
	
	(method (handleEvent event)
		(cond 
			((or (MousedOn self event shiftDown) (Said 'examine/ladder'))
				(event claimed: TRUE)
				(Print 3 38)
			)
			((Said 'climb[/ladder,tower]')
				(if nearLadder
					(ego setScript: climbDown)
				else
					(NotClose)
				)
			)
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 31
		loop 2
		cycleSpeed 16
	)
)
