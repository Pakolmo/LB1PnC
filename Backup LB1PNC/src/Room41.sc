;;; Sierra Script 1.0 - (do not remove this comment)
(script# 41)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room41 0
)
(synonyms
	(drawer chest dresser)
	(room bedroom)
	(armoire armoire)
)

(local
	local0
	temp7
)
(instance Room41 of Room
	(properties
		picture 41
	)
	
	(method (init)
		(= east 42)
		(super init:)
		(addToPics
			add: wardrobe chair1 chair2 dresser
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures: lamp1 lamp2 wardrobe dresser chair1 chair2 Boxes
		)
		(cond 
			((<= currentAct 1) (bag init: stopUpd:) (Bclr 35))
			(
				(and
					(>= currentAct 6)
;;;					(not (& deadGuests deadRUDY))
;;;					(not (& deadGuests deadLILLIAN))
					(not (& deadGuests $0020))
					(not (& deadGuests $0040))
				)
				(cond 
					((== gCurRoomNum_3 41) (++ local0)
						(self setRegions: 278)
					)
					((not (== gCurRoomNum_3 73))
						(switch (Random 1 2)
							(1
								(++ local0)
								(self setRegions: 278)
							)
							(2 (= gCurRoomNum_3 73))
						)
					)
				)
			)
		)
		(Bed
			cel: (if (Btst 35) 0 else 4)
			ignoreActors: TRUE
			init:
			stopUpd:
		)
		(Load VIEW 30)
		(if howFast
			(lamp1 setCycle: Forward init:)
			(lamp2 setCycle: Forward init:)
		else
			(lamp1 init: stopUpd:)
			(lamp2 init: stopUpd:)
		)
;;;		(ego view: 0 posn: 304 122 illegalBits: (| cWHITE cCYAN) init:)
		(ego view: 0 posn: 304 122 illegalBits: -32760 init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 41 0)
		)
		(if (< (ego x?) 250)
			(= vertAngle 44)
		else
			(= vertAngle 0)
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
					
				(if (ClickedOnObj wardrobe (event x?) (event y?)) 

					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {examine in armoire})
						)
						(998
							(DoVerb {examine armoire})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
		
					(if (ClickedOnObj chair1 (event x?) (event y?)) 
							
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {look chair})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
		
					(if (ClickedOnObj chair2 (event x?) (event y?)) 
							
					(event claimed: TRUE)
					(switch theCursor
												(995
							(DoVerb {examine in chair})
						)
						(998

							(DoVerb {look chair})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)
			
		
				(if (ClickedOnObj Boxes (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {examine in box})
						)
						(998

							(DoVerb {examine box})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)
			
			
;;;					(if (and (ClickedOnObj Bed (event x?) (event y?)) 
					(if (and (ClickedInRect 178 223 75 98 event)
								(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor
						(995
													(= temp7
												(Print
													{Bed}
													#button {Open} 1
													#button {Close} 2								
													#button {Examine} 3

												)
											)
											(switch temp7
												(1 
													(DoVerb {open bed})
												)
												(2
													(DoVerb {close bed})
												)
												(3
													(DoVerb {examine below bed})
												)(else
													(event claimed: FALSE)
												)
											)
						
												
						)
						(998

							(DoVerb {examine bed})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)
				
					(if (ClickedOnObj bag (event x?) (event y?)) 
							
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {examine in bag})
						)
						(998

							(DoVerb {examine bag})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)		
					(if (or (ClickedOnObj lamp1 (event x?) (event y?)) 
						(ClickedOnObj lamp2 (event x?) (event y?)) )
					(event claimed: TRUE)
					(switch theCursor
						(998

							(DoVerb {examine lamp})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)		
		
				
				(if (ClickedOnObj dresser (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998

							(DoVerb {examine in drawer})
						
						)(else
							(event claimed: FALSE)
						)
					)
					)	
		
			(if (ClickedInRect 304 319 117 128 event) ;exit room
			(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo 321 128)
						)
						(else
								(event claimed: FALSE)
						)
					 )
				
				)
		
				(if (ClickedInRect 309 319 113 128 event) ;exit room
			(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo 321 120)
						)
						(else
								(event claimed: FALSE)
						)
					 )
				
				)	
				(if (ClickedInRect 151 173 22 49 event) ;curtain
					
					
					(event claimed: TRUE)
					(switch theCursor
						(995
									(DoVerb {examine below curtain})
						)
						(998
							(DoVerb {examine curtain})
						
						)	(else
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
					((Said '*/blind,curtain')
						(Print 41 1)
					)
					((Said 'examine>')
						(cond 
							((and (not (cast contains: bag)) (Said '/bag'))
								(DontSee)
							)
							((Said '[<around,at][/room]') (Print 41 0))
							((Said '/furniture[<covered]') (Print 41 2))
							((Said '<in/closet') (Print 41 3))
							((Said '/closet') (Print 41 4))
							((Said '<below/cover[<furniture]') (Print 41 5) (Print 41 6))
						)
					)
					((Said 'get/cover[<furniture]') (Print 41 5))
					((Said 'open/closet') (Print 41 7))
					(
						(or
							(Said 'uncover/furniture')
							(Said 'detach,get/cover')
						)
						(Print 41 5)
					)
					(
						(or
							(Said 'open/(bed[<murphy]),door')
							(Said 'lower,drag/bed[<murphy]')
						)
						(if (Btst 35)
							(self setScript: myBed)
						else
							(AlreadyOpen)
						)
					)
					(
					(Said 'close,lift,lift,attach,press/bed[<murphy,up,away]')
						(if (not (cast contains: bag))
							(cond 
								((and (== gCurRoomNum_3 41) (not (& deadGuests deadRUDY)))
									(Print 41 8)
								)
								((not (Btst 35))
									(self setScript: myBed)
								)
								(else
									(AlreadyClosed)
								)
							)
						else
							(Bset 31)
							(Print 41 9)
						)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(DisposeScript AVOIDER)
		(super newRoom: n)
	)
)

(instance myBed of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (Btst 35)
					(ego
						setAvoider: (Avoider new:)
						setMotion: MoveTo 243 90 self
					)
				else
					(ego
						setAvoider: (Avoider new:)
						setMotion: MoveTo 189 99 self
					)
				)
			)
			(1
				(if (Btst 35)
					(Bclr 35)
					(ego loop: 1 observeControl: 8)
					(Bed cycleSpeed: 3 setCycle: EndLoop self)
				else
					(Bset 35)
					(ego
						view: 30
						cel: 0
						loop: 1
						setCycle: EndLoop
						ignoreControl: 8
					)
					(Bed cycleSpeed: 3 setCycle: BegLoop self)
				)
			)
			(2
				(Bed stopUpd:)
				(if (Btst 35)
					(ego
						view: 0
						loop: 3
						posn: 179 99
						setAvoider: 0
						setCycle: Walk
					)
				)
				(HandsOn)
				(self setScript: 0)
			)
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 95
		x 112
		view 141
		loop 1
		priority 3
	)
	
	(method (handleEvent event)
		(cond 
			((Said '(examine<in),open/armoire')
				(Print 41 7)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(event claimed: TRUE)
				(Print 41 4)
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 90
		x 132
		view 141
		loop 1
		cel 3
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance dresser of RPicView
	(properties
		y 89
		x 292
		view 141
		loop 1
		cel 1
		priority 5
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine[<!*]/drawer')
			)
			(event claimed: TRUE)
			(Print 41 10)
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 113
		x 93
		view 141
		loop 1
		cel 2
		priority 7
	)
	
	(method (handleEvent event)
		(cond 
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(DoLook {chair})
			)
			((Said '(examine<in),open/box')
				(Print 41 11)
			)
			((Said 'examine/box')
				(Print 41 12)
			)
			((Said 'move,get/box')
				(Print 41 13)
			)
		)
	)
)

(instance Bed of Prop
	(properties
		y 29
		x 232
		view 141
		loop 2
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<below/bed')
				(Print 41 14)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/bed[<murphy]')
				)
				(event claimed: TRUE)
				(cond 
					(local0
						(Print 41 15)
					)
					((== (Bed cel?) 0)
						(Print 41 16)
					)
					((cast contains: bag)
						(Bset 31)
						(Print 41 17)
					)
					(else
						(Print 41 18)
					)
				)
			)
		)
	)
)

(instance bag of Prop
	(properties
		y 79
		x 212
		view 141
		loop 1
		cel 4
	)
	
	(method (handleEvent event)
		(if (not (event claimed?))
			(cond 
				((Said 'search,move,get,open,(examine<in)/bag')
					(Print 41 19)
				)
				((or (MousedOn self event shiftDown) (Said 'examine/bag'))
					(event claimed: TRUE)
					(Print 41 20)
				)
			)
			(if (event claimed?)
				(Bset 31)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 51
		x 89
		view 141
		priority 1
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
		y 63
		x 61
		view 141
		cel 1
		priority 2
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance Boxes of RFeature
	(properties
		nsTop 108
		nsLeft 50
		nsBottom 169
		nsRight 308
	)
	
	(method (handleEvent event)
		(cond 
			((Said '(examine<in),open/box')
				(Print 41 11)
			)
			((Said 'move,get/box')
				(Print 41 13)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/box'))
				(event claimed: TRUE)
				(Print 41 12)
			)
		)
	)
)
