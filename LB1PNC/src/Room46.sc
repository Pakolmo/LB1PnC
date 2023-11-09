;;; Sierra Script 1.0 - (do not remove this comment)
(script# 46) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room46 0
)
(synonyms
	(painting blaze)
	(luggage case bag)
	(drawer dresser)
	(room bedroom)
)

(local
	local0
	local1
	local2
	temp7
)
(instance myMusic of Sound)

(instance Room46 of Room
	(properties
		picture 46
	)
	
	(method (init)
		(= east 47)
		(super init:)
		(addToPics
			add: suit1 suit2 horse bed1 bed2 chest table2 sofa
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures: suit1 suit2 horse table2 bed1 bed2 sofa chest
		)
		(table
			cel:
			(switch currentAct
				(1 9)
				(else  8)
			)
			setPri: 6
			init:
			stopUpd:
		)
		(if (== global177 2)
			(table cel: 8)
		)
		(if (and (== currentAct 1) (!= global177 2))
			(plant setPri: 6 init: stopUpd:)
		)
		(if howFast
			(lamp1 setPri: 6 setCycle: Forward init:)
			(lamp2 setPri: 6 setCycle: Forward init:)
		else
			(lamp1 setPri: 6 init: stopUpd:)
			(lamp2 setPri: 6 init: stopUpd:)
		)
		(Bwindow ignoreActors: TRUE setPri: 7 init: stopUpd:)
		(panel
			setLoop: 1
			setCel: 11
			illegalBits: 0
			setPri: 4
			init:
			stopUpd:
		)
		(LoadMany SOUND 74 75)
		(switch currentAct
			(0
				(if (& global173 $0002)
					(self setRegions: 224)
					(= local0 1)
				)
				(= global177 0)
			)
			(1
				(if (< global177 2)
					(= local1 1)
					(Bwindow
						view: 246
						setPri: 9
						loop: 2
						cel: 0
						posn: 37 127
						cycleSpeed: 2
						ignoreActors: FALSE
						setCycle: Forward
					)
					(Twindow
						cycleSpeed: 2
						cel: (- (NumCels Bwindow) 2)
						setCycle: Forward
						init:
					)
					(myMusic number: 12 loop: -1 play:)
				)
			)
		)
		(if (!= prevRoomNum 49)
			(ego view: 0 illegalBits: (| cWHITE cGREEN) posn: 304 101 init:)
		else
			(ego
				view: 0
				illegalBits: cWHITE
				setPri: 2
				loop: 2
				posn: 152 79
				init:
			)
			(if (== local0 0)
				(ego posn: 152 79)
				(self setScript: enterPanel)
			)
		)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 46 0)
		)
		(if (and (== currentAct 1) (== global177 0))
			(Printf 46 1 46 2)
			(Print 46 3)
			(= global177 1)
			(= local2 1)
		)
		(if
			(or
				(ego inRect: 60 80 116 104)
				(ego inRect: 178 82 213 105)
			)
			(ego setPri: 5)
		else
			(ego setPri: -1)
		)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		
		
		suit1 suit2 horse bed1 bed2 chest table2 sofa
		table plant lamp1 lamp2 Bwindow Twindow
		
			(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				(if (ClickedOnObj Gertie (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoVerb {examine gertie})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)					
		
		
		
					(if (ClickedOnObj horse (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995 ;examine	
	
								(= temp7
												(Print
;;;													{Picture}
;;;													#button {Get} 1
;;;													#button {Open} 2								
													{Cuadro}
													#button {Coger} 1
													#button {Abrir} 2													
												)
											)
											(switch temp7
												(1 		
													(DoVerb {Get painting})
												)
												(2
													(DoVerb {Open painting})
												)
												(else
													(event claimed: FALSE)
												)
											)
						)
						(998
														(= temp7
												(PrintSpecial
													{Cuadro}
													#button {examinar} 1
													#button {examinar por detr*s} 2								
;;;													{Picture}
;;;													#button {examine} 1
;;;													#button {examine behind} 2														
												)
											)
											(switch temp7
												(1 		
													(DoVerb {examine eye})
												)
												(2
													(DoVerb {examine behind painting})
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
		
					(if (and (ClickedOnObj bed1 (event x?) (event y?)) 
							(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(Print 46 15)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)					
			
					(if (and (ClickedOnObj chest (event x?) (event y?)) 
					(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(Print 46 16)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
		
					(if (and (ClickedOnObj bed2 (event x?) (event y?)) 
						(== (event claimed?) FALSE))
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoLook {bed})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
		
					(if (ClickedOnObj table2 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoLook {table})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
		
						(if (ClickedOnObj sofa (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoLook {couch})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
		
											
						(if (and (ClickedOnObj suit1 (event x?) (event y?)) 
								(== (event claimed?) FALSE)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(Print 46 19)
						)
						(995 ;hand
							(= temp7
												(Print
;;;													{luggage}
;;;													#button {open} 1
;;;													#button {get} 2								
													{Equipaje}
													#button {Abrir} 1
													#button {Coger} 2														
												)
											)
											(switch temp7
												(1 		
													(DoVerb {open luggage})
												)
												(2
													(DoVerb {get luggage})
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
		
		
		
							(if (and (ClickedOnObj suit2 (event x?) (event y?)) 
								(== (event claimed?) FALSE)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(Print 46 19)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
			
			
							(if (ClickedOnObj Bwindow (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(= temp7
												(PrintSpecial
;;;													{Window}
;;;													#button {examine curtain} 1
;;;													#button {examine down} 2	
;;;													#button {examine window} 3								
													{Ventana}
													#button {Examinar cortina} 1
													#button {Examinar fuera} 2	
													#button {Examinar ventana} 3													
												)
											)
											(switch temp7
												(1 		
													(DoVerb {examine curtain})
												)
												(2
													(DoVerb {examine down window})
												)
												(3
													(DoVerb {examine Window})
												)												
												(else
													(event claimed: FALSE)
												)
											)
						)
						(995
							(= temp7
												(Print
;;;													{Window}
;;;													#button {climb out} 1
;;;													#button {Open} 2	
;;;													#button {Close} 3								
													{Ventana}
													#button {Subir a} 1
													#button {Abrir} 2	
													#button {Cerrar} 3													
												)
											)
											(switch temp7
												(1 		
													(DoVerb {climb out window})
												)
												(2
													(DoVerb {Open window})
												)
												(3
													(DoVerb {Close Window})
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
								(if (ClickedOnObj lamp1 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoLook {lamp})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
				
								(if (ClickedOnObj lamp2 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998 ;examine
							(DoLook {lamp})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)			
								(if (ClickedOnObj table (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {get nightstand})
						)
						(998 ;examine
							(DoVerb {examine nightstand})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
				
								(if (ClickedOnObj plant (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {look plant})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)				
				
					(if (ClickedInRect 313 319 93 104 event) ;exit room
			(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo 321 99)
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
					((Said 'examine,find/gertie,body')
						(if (== currentAct 0)
							(event claimed: 0)
						else
							(Print 46 4)
						)
					)
					((Said '/panel,(door<hidden)>')
						(cond 
							((and (& global175 $0040) (Said 'open,move'))
								(if (not local0)
									(if (& (ego onControl: FALSE) cRED)
										(HandsOff)
										(self setScript: exiting)
									else
										(NotClose)
									)
								else
									(Print 46 5)
								)
							)
							((Said 'examine')
								(if (& global175 $0040)
									(Print 46 6)
								else
									(Print 46 7)
								)
							)
						)
					)
					((Said 'examine[<around,at][/room]')
						(if (and (== currentAct 1) local1)
							(Printf 46 1 46 2)
							(Print 46 3)
						else
							(Print 46 0)
						)
					)
					((Said 'smell/smoke,butt')
						(if (and (== currentAct 1) local2)
							(Print 46 8)
						else
							(event claimed: FALSE)
						)
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

(instance enterPanel of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 1)
				(panel setMotion: MoveTo 180 84 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(1
				(ego setMotion: MoveTo (ego x?) (+ (ego y?) 15) self)
			)
			(2
				(ego setPri: -1 illegalBits: (| cWHITE cGREEN))
				(panel setMotion: MoveTo 155 84 self)
				(myMusic number: 75 loop: 1 play:)
			)
			(3
				(HandsOn)
				(Print 46 9)
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance exiting of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global204 1)
				(panel setMotion: MoveTo 180 84 self)
				(myMusic number: 74 loop: 1 play:)
			)
			(1
				(if (ego inRect: 150 87 154 90)
					(= cycles 1)
				else
					(ego illegalBits: cWHITE setMotion: MoveTo 152 85 self)
				)
			)
			(2
				(ego illegalBits: cWHITE setMotion: MoveTo 154 79 self)
			)
			(3
				(ego setPri: 2)
				(panel setMotion: MoveTo 155 84 self)
				(myMusic number: 75 loop: 1 play:)
			)
			(4
				(HandsOn)
				(= global204 0)
				(curRoom newRoom: 49)
				(client setScript: 0)
			)
		)
	)
)

(instance closeWindow of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego setMotion: MoveTo 75 120 self)
			)
			(1
				(ego loop: 1)
				(Twindow hide:)
				(Bwindow
					posn: 37 127
					loop: 0
					cel: 3
					setPri: 7
					setCycle: BegLoop self
				)
			)
			(2
				(myMusic stop:)
				(Bwindow ignoreActors: TRUE setPri: 7 stopUpd:)
				(= local1 0)
				(= global177 3)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)
(instance Gertie of Actor)
(instance horse of RPicView
	(properties
		y 53
		x 183
		view 146
		priority 5
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<behind,below/painting')
				(Print 46 10)
			)
			((Said 'get/painting')
				(Print 46 11)
			)
			((Said 'open/painting')
				(Print 46 12)
			)
			((Said 'examine/eye,(painting<eye)')
				(Print 46 13)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/painting')
					(Said 'examine/painting/painting')
				)
				(event claimed: TRUE)
				(Print 46 14)
			)
		)
	)
)

(instance bed1 of RPicView
	(properties
		y 106
		x 110
		view 146
		cel 4
		priority 6
		signal $4000
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 46 15)
		)
	)
)

(instance chest of RPicView
	(properties
		y 93
		x 182
		view 146
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
			(Print 46 16)
		)
	)
)

(instance bed2 of RPicView
	(properties
		y 107
		x 215
		view 146
		cel 5
		priority 6
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (and (not local0) (MousedOn self event shiftDown))
			(event claimed: TRUE)
			(DoLook {bed})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 94
		x 256
		view 146
		cel 2
		priority 5
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
		y 157
		x 133
		view 146
		cel 7
		priority 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {couch})
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 119
		x 211
		view 146
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/luggage')
				(Print 46 17)
			)
			((Said 'get/luggage')
				(Print 46 18)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/luggage'))
				(event claimed: TRUE)
				(Print 46 19)
			)
		)
	)
)

(instance suit2 of RPicView
	(properties
		y 86
		x 106
		view 146
		cel 6
		priority 7
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 46 19)
		)
	)
)

(instance Twindow of Prop
	(properties
		y 37
		x 60
		view 246
		loop 1
	)
)

(instance Bwindow of Prop
	(properties
		y 127
		x 37
		view 246
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine/curtain')
				(if local1
					(Print 46 20)
				else
					(event claimed: FALSE)
				)
			)
			((Said '(go,climb,hop)<out/window')
				(if local1
					(Print 46 21)
				else
					(Print 46 22)
				)
			)
			((Said 'open/window')
				(if local1
					(Print 46 23)
				else
					(Print 46 24)
				)
			)
			((Said 'close/window')
				(if local1
					(if (& (ego onControl: FALSE) cCYAN)
						(self setScript: closeWindow)
					else
						(NotClose)
					)
				else
					(Print 46 25)
				)
			)
			(
				(or
					(Said 'examine[<down]/dirt')
					(Said 'examine<(down,out)')
					(Said 'examine<(out,through)/window')
				)
				(if local1
					(if (& (ego onControl: FALSE) cCYAN)
						(Print 46 26)
					else
						(NotClose)
					)
				else
					(event claimed: FALSE)
				)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(if local1
					(Print 46 27)
				else
					(DoLook {window})
				)
			)
			((Said 'examine/window')
				(if local1
					(Print 46 27)
				else
					(event claimed: FALSE)
				)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 45
		x 120
		view 148
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
		y 46
		x 250
		view 148
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance panel of Actor
	(properties
		y 84
		x 155
		view 146
	)
)

(instance table of Prop
	(properties
		y 111
		x 72
		view 146
	)
	
	(method (handleEvent event)
		(cond 
			((and (== currentAct 1) (!= global177 2))
				(cond 
					((or (Said 'examine/dirt') (Said 'examine<down'))
						(Print 46 28)
					)
					((Said 'get,straighten/nightstand,foliage')
						(Print 46 29)
					)
					(
						(or
							(Said 'examine/nightstand,foliage')
							(MousedOn self event shiftDown)
						)
						(Print 46 30)
						(event claimed: TRUE)
					)
				)
			)
			((or (Said 'examine/foliage') (MousedOn self event shiftDown))
				(Print 46 31)
			)
		)
	)
)

(instance plant of Prop
	(properties
		y 109
		x 99
		view 146
		cel 10
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/foliage'))
			(event claimed: TRUE)
			(Print 46 32)
		)
	)
)
