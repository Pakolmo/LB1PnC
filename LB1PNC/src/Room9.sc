;;; Sierra Script 1.0 - (do not remove this comment)
(script# 9)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room9 0
)
(synonyms
	(gravestone crypt)
	(room room chapel)
)

(local
	local0
	local1
	local2
	temp7
)
(instance Room9 of Room
	(properties
		picture 9
	)
	
	(method (init)
		(= south 13)
		(= east 3)
		(= horizon 86)
		(super init:)
		(LoadMany SOUND 43 44)
		(Thunder number: 17 loop: 0)
		(if (== currentAct 1)
			(self setRegions: 381)
		)
		(if howFast
			(light1 init: setScript: showers)
		)
		(Door ignoreActors: TRUE stopUpd: init:)
;;;		(ego view: 0 illegalBits: (| cWHITE cBLUE))
		(ego view: 0 illegalBits: -32766)
		(self setFeatures: Window1 Window2)
		(if (and (>= currentAct 2) (< currentAct 4))
			(self setRegions: 202)
		)
		(if
			(or
				(and (== currentAct 3) (!= global114 10))
				(and (== currentAct 6) (not (& global118 $0002)))
			)
			(self setRegions: 281)
		)
		(= local0 0)
		(switch prevRoomNum
			(14
				(ego posn: 285 188)
			)
			(2
				(ego posn: 58 114)
			)
			(13
				(ego posn: 68 185)
			)
			(58
				(if (== global133 1)
					(Door cel: 0)
					(ego posn: 109 122)
				else
					(Door cel: (- (NumCels Door) 1))
					(HandsOff)
					(ego loop: 2 illegalBits: cWHITE posn: 237 132)
					(self setScript: exitDoor)
				)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 9 0)
		)
		(super doit:)
		(switch (ego onControl: origin)
			(64
				(if (or (== (ego loop?) 1) (== (ego loop?) 3))
					(= local2 1)
					(User canControl: 0)
					(ego illegalBits: 0 setLoop: 1 setMotion: MoveTo 268 133)
				)
			)
			(128
				(if (or (== (ego loop?) 0) (== (ego loop?) 2))
					(= local2 1)
					(User canControl: 0)
					(ego setLoop: 0 illegalBits: 0 setMotion: MoveTo 294 158)
				)
			)
			(1
				(if (== local2 1)
					(= local2 0)
					(User canControl: TRUE)
					(ego illegalBits: cWHITE setLoop: -1)
				)
			)
			(8 
				(curRoom newRoom: 2)
			)
			(4
				(= global133 1)
				(curRoom newRoom: 58)
			)
			(2
				(HandsOn)
				(= global133 0)
				(self setScript: 0)
				(curRoom newRoom: 58)
			)
			(16
				(if
					(and
						(or (== (ego loop?) 3) (== (ego loop?) 1))
						(not local1)
					)
					(HandsOff)
					(= local1 1)
					(self setScript: chapelDoor)
				)
			)
		)
		(if (== (ego edgeHit?) SOUTH)
			(if (< (ego x?) 275)
				(curRoom newRoom: 13)
			else
				(curRoom newRoom: 14)
			)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
;;;		(method (handleEvent event)
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)

				(if (ClickedInRect 0 319 180 189 event) ;exit room down
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
				
					(if (ClickedInRect 312 319 94 189 event) ;exit room right
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

				
				(if (ClickedOnObj Door (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(995
								(= temp7
												(Print
													{Door}
													#button {Open} 1
													#button {Close} 2								


												)
											)
											(switch temp7
												(1 
													(DoVerb {open door})
														
												)
						
										

												(2
													(DoVerb {close door})
													
				
												)
												(else
													(event claimed: FALSE)
												)
											)
						

													
							
						)
				
						(998
							(DoVerb {examine door})	
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
						
							
		
					(if (ClickedOnObj light1 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
							(DoVerb {examine door})	;yes
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
						
							
					(if (ClickedOnObj Window1 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(995
									(= temp7
												(Print
													{Window}
													#button {Examine} 1
													#button {Examine In} 2								


												)
											)
											(switch temp7
												(1 
													(DoVerb {examine window})
														
												)
						
										

												(2
													(DoVerb {examine in window})
													
				
												)
												(else
													(event claimed: FALSE)
												)
											)
						

						)
						(998
								(= temp7
												(Print
													{Window}
													#button {Examine} 1
													#button {Examine In} 2								


												)
											)
											(switch temp7
												(1 
													(DoVerb {examine window})
														
												)
						
										

												(2
													(DoVerb {examine in window})
													
				
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
						
					
		
				(if (ClickedOnObj Window2 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
							(DoVerb {examine window})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
		
			(if (ClickedInRect 0 44 73 81 event) ;cementery
					
					
					(event claimed: TRUE)
					(switch theCursor
						(998
									(DoVerb {examine cementery})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				(if (ClickedInRect 36 69 76 110 event) ;archway/arco
					
					
					(event claimed: TRUE)
					(switch theCursor
						(995
									(= temp7
												(Print
													{Archway}
													#button {Open} 1
													#button {Close} 2								


												)
											)
											(switch temp7
												(1 
													(DoVerb {open archway})
														
												)
						
										

												(2
													(DoVerb {close archway})
													
				
												)
												(else
													(event claimed: FALSE)
												)
											)
						

													
							
						)
						(998
														(= temp7
												(Print
													{Archway}
													#button {Examine} 1
													#button {Examine grave} 2								


												)
											)
											(switch temp7
												(1 
													(DoVerb {examine archway})
														
												)
						
										

												(2
													(DoVerb {examine grave})
													
				
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
		
		
						(if (ClickedInRect 1 42 81 121 event) ;fence
					
					
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {climb fence})
						)
						(998
							(DoVerb {examine fence})
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
			(cond 
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]') (Print 9 0))
						((Said '/cemetery') (Print 9 1))
						((Said '/fence') (Print 9 2))
						((Said '/archway') (Print 9 3))
						((Said '/field[<sugar,cane]') (Print 9 4))
						((Said '/path') (Print 9 5))
						((Said '/stair') (Print 9 6))
						((Said '/gallery') (Print 9 7))
						((Said '/cross') (Print 9 8))
						((Said '/grave,gravestone,epitaph') (Print 9 9))
						((Said '<behind/blind') (Print 9 10))
					)
				)
				((Said 'get/cross') (Print 9 11))
				((Said 'read/gravestone,epitaph') (Print 9 9))
				((Said 'bang[/door]') (Print 9 12))
				((Said 'find/archway') (Print 9 3))
				((Said 'climb,hop/fence') (Print 9 13))
				((Said 'open>')
					(cond 
						((Said '/archway') (AlreadyOpen))
						((Said '/door') (Print 9 14))
					)
				)
				((Said 'close>')
					(cond 
						((Said '/archway') (Print 9 15))
						((Said '/door,window') (AlreadyClosed))
					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(if (or (== n 58) (== n 2)) (cSound stop:))
		(super newRoom: n)
	)
)

(instance chapelDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego illegalBits: 0)
				(= cycles 2)
			)
			(1
				(ego setMotion: MoveTo 240 128 self)
			)
			(2
				(ego loop: 1)
				(cSound stop:)
				(Door startUpd: ignoreActors: TRUE setCycle: EndLoop self)
				(mySound number: 43 loop: 1 priority: 5 play:)
			)
			(3
				(ego setMotion: MoveTo 225 128)
			)
		)
	)
)

(instance exitDoor of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 44 loop: 1 priority: 5 play:)
				(Door setCycle: BegLoop self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance showers of Script

	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (= state 3)))
			(1
				(light1 setCycle: Forward)
				(= cycles 7)
			)
			(2
				(light1 setCycle: EndLoop self)
				(Thunder loop: 1 play:)
			)
			(3
				(if (< (Random 1 100) 20)
					(= state 0)
				)
				(= cycles 7)
			)
			(4
				(= state 2)
				(= seconds 5)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 130
		x 222
		view 109
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/door'))
			(event claimed: TRUE)
			(if (ego inRect: 0 0 120 140)
				(Print 9 16)
			else
				(Print 9 17)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 26
		x 64
		view 109
		loop 1
		cel 1
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/door'))
			(event claimed: TRUE)
			(Print 9 17)
		)
	)
)

(instance Thunder of Sound)

(instance mySound of Sound)

(instance Window1 of RFeature
	(properties
		nsTop 63
		nsLeft 119
		nsBottom 107
		nsRight 135
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<(in,in,in,through)/window,room')
				(if (& (ego onControl: origin) cMAGENTA)
					(Print 9 18)
				else
					(NotClose)
				)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/window'))
				(event claimed: TRUE)
				(Print 9 19)
			)
			((Said 'open/window')
				(Print 9 20)
			)
			((Said 'break/window')
				(Print 9 21)
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 61
		nsLeft 160
		nsBottom 108
		nsRight 193
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/window'))
			(event claimed: TRUE)
			(Print 9 19)
		)
	)
)
