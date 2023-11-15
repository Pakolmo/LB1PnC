;;; Sierra Script 1.0 - (do not remove this comment)
(script# 31) ;213 380 384 264
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
	Room31 0
)
(synonyms
	(room read)
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	firstTime
	local9
	temp7
	temp8
)
(instance Room31 of Room
	(properties
		picture 31
	)
	
	(method (init)
		(= east 32)
		(super init:)
		(= firstTime (FirstEntry))
		(addToPics
			add:
				crossbow
				rhino
				tomahawk
				aligator
				hawk
				globe
				firetools
				logs
				bookcase
				sofa
				wingback
				chair
				table1
				table2
			eachElementDo: #init
			doit:
		)
		(LoadMany SOUND 43 44)
		(self
			setRegions: 213
			setFeatures:
				crossbow
				rhino
				logs
				sofa
				wingback
				chair
				table1
				table2
				lamp1
				lamp2
				aligator
				hawk
				globe
				tomahawk
				Desk
				Spear
				Window1
				Window2
		)
		(if howFast
			(lamp1 setPri: 5 setCycle: Forward init:)
			(lamp2 setPri: 11 setCycle: Forward init:)
		else
			(lamp1 setPri: 5 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(derringer
			cel: (if (< currentAct 6) 3 else 4)
			setPri: 11
			ignoreActors: TRUE
			init:
			stopUpd:
		)
		(Fdoor
			cel: (if (== prevRoomNum 10) 2 else 0)
			priority: 7
			ignoreActors: TRUE
			init:
			stopUpd:
		)
		(Bdoor
			cel: (if (== prevRoomNum 10) 2 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= gMySound Fdoor)
		(= gBdoor Bdoor)
		(sphere setPri: 13 init: stopUpd:)
		(gundoor
			cel: (if (Btst 47) 1 else 0)
			setPri: 5
			init:
			stopUpd:
		)
		(= gDoor gundoor)
		(cabDoor setPri: 5 init: stopUpd:)
		(switch currentAct
			(0
				(if (or (== [global368 3] 1) (== global124 1))
					(self setRegions: 380)
				)
			)
			(1
				(if (== global154 1) (self setRegions: 384))
			)
			(3
				(if (not (& global118 $0002))
					(HandsOff)
					(self setRegions: 264)
					(gundoor cel: 1)
					(= local6 1)
				)
			)
		)
		(if
			(and
				(<= (Random 1 100) 35)
				(> currentAct 0)
				(< currentAct 7)
			)
			(if local6
				(= local0 0)
			else
				(Shadow illegalBits: 0 posn: 133 82 setPri: 2 init:)
				(Shadow setScript: shadowWalk)
			)
		)
		(if (== prevRoomNum 32)
			(ego posn: 310 123)
		else
			(ego posn: 84 124)
			(if (not firstTime) (Fdoor setScript: closeDoor))
		)
		(ego view: 0 illegalBits: (| cWHITE cGREEN) init:)
	)
	
	(method (doit)
		(if firstTime
			(Print 31 0)
			(if (== prevRoomNum 10) (Fdoor setScript: closeDoor))
			(= firstTime 0)
		)
		(if
			(and
				(& (ego onControl: 0) cRED)
				(== (ego loop?) 1)
				(not script)
			)
			(HandsOff)
			(self setScript: myDoor)
		)
		(if (ego inRect: 235 102 267 118)
			(ego setPri: 8)
		else
			(ego setPri: -1)
		)
		(if (& (ego onControl: origin) cGREEN)
			(curRoom newRoom: 10)
			(if (or (== global154 1) (== global154 2))
				(= global154 3)
			)
		)
		(if (< (ego x?) 190)
			(= vertAngle 44)
		else
			(= vertAngle 0)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript FOLLOW)
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
				
				(if (ClickedInRect 309 319 115 127 event) ;exit room right
					(event claimed: TRUE)
					(switch theCursor
						(999
							(ego setMotion: MoveTo 321 121)
						)
						(else
							(event claimed: FALSE)
						)
					 )
				)					
				(if (ClickedOnObj rhino (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {get head})
						)
						(998
														(= temp7
								(PrintSpecial
;;;									{Rhino}
;;;									#button {Examine} 1
;;;									#button {Examine in} 2
									{Rhino}
									#button {Mirar} 1
									#button {Examinar} 2		
								)
							)
							(switch temp7
								(1 		
									(DoVerb {examine head})
								)
								(2
									(DoVerb {examine in head})
							
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
		
						(if (ClickedOnObj logs (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine fireplace})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
		
				(if (ClickedOnObj aligator (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine alligator})
						)
						(995
							(DoVerb {get alligator})
						)						
						(else
							(event claimed: FALSE)
						)
					)
				)	
			
		
;;;				(if (ClickedOnObj sofa (event x?) (event y?)) ;BUG WITH LILLIAN
;;;					(event claimed: TRUE)
;;;					(switch theCursor	
;;;						(998
;;;							(DoVerb {examine chair})
;;;						)					
;;;						(else
;;;							(event claimed: FALSE)
;;;						)
;;;					)
;;;				)	
					
		
				(if (ClickedOnObj wingback (event x?) (event y?))  
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
		
					(if (ClickedOnObj chair (event x?) (event y?)) 
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
				
					(if (ClickedOnObj table1 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine table})
						)					
						(else
							(event claimed: FALSE)
						)
					)
				)	
						
					(if (ClickedOnObj table2 (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine table})
						)					
						(else
							(event claimed: FALSE)
						)
					)
				)	
												
				
					(if (ClickedOnObj hawk (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(cond 
								((super handleEvent: event))
								((or (MousedOn self event shiftDown) (Said 'examine/bird'))
									(event claimed: TRUE)
									(Print 31 2)
								)
							)
						)
										
						(else
							(event claimed: FALSE)
						)
					)
				)	
				
				
				
				(if (ClickedOnObj globe (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998
						(= temp7
								(PrintSpecial
;;;									{Globe}
;;;									#button {Examine below} 1
;;;									#button {Examine in} 2
;;;									#button {Examine} 3
									{Tierra}
									#button {Mirar debajo} 1
									#button {Examinar} 2
									#button {Mirar} 3											
								)
							)
							(switch temp7
								(1 		
									(DoVerb {examine below globe})
								)
								(2
									(DoVerb {examine in globe})
							
								)
								(3
									(DoVerb {examine globe})
							
								)								
								(else
									(event claimed: FALSE)
								)
							)
						)
							
						
						(995
												(= temp7
								(PrintSpecial
;;;									{Globe}
;;;									#button {Move} 1
;;;									#button {Get} 2
;;;									#button {Open} 3
;;;									#button {Rotate} 4
									{Tierra}
									#button {Mover} 1
									#button {Coger} 2
									#button {Abrir} 3											
									#button {Girar} 4
								)
							)
							(switch temp7
								(1 		
									(DoVerb {move globe})
								)
								(2
									(DoVerb {get globe})
							
								)
								(3
									(DoVerb {open globe})
							
								)
								(4
									(DoVerb {rotate globe})
							
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
				
				(if (ClickedOnObj crossbow (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998
							(DoVerb {examine crossbow})
							 (cond 
								((super handleEvent: event))
								(


										(Said 'examine/crossbow[<antique]')

									(event claimed: TRUE)
									(Print 31 39)
								)	
							 )
						)
					
						(995
							
							(DoVerb {get crossbow})
									(cond 
										((super handleEvent: event))
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
						(998				
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
						(998				
							(DoLook {lamp})
						)
						(else
									(event claimed: FALSE)
								)
					)
					)						
					
						(if (ClickedOnObj tomahawk (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {get ax feathered})
							(cond 
								((super handleEvent: event))

							)
						)
						(998
								(DoVerb {examine ax feathered})											
							(cond 
								((super handleEvent: event))

							)
						)
						(else
									(event claimed: FALSE)
								)
						)
					)					



						(if (ClickedOnObj Spear (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(995
								(DoVerb {get spear})	
						)
						(998
							(DoVerb {examine spear})
						)
						(else
								(event claimed: FALSE)
							)
						)
					)		
						(if (ClickedOnObj Desk (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(995
								(DoVerb {open desk})	
						)
						(998
							(DoVerb {examine desk})
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
							(DoVerb {examine window})
						)
						(else
								(event claimed: FALSE)
							)
						)
					)		

						(if (or (ClickedOnObj Bdoor (event x?) (event y?)) 
								(ClickedOnObj Fdoor (event x?) (event y?)) )
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


						(if (and (ClickedOnObj gundoor (event x?) (event y?)) 
							(== opendoor 1))
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(if (Btst 47)
								(Print 31 3)
							else
								(Print 31 4)
							)
														(= temp7
								(PrintSpecial
;;;									{Examine}

;;;									#button {Armoire} 1
;;;									#button {Weapon} 2
;;;									#button {boomerang} 2
;;;									#button {Cutlass} 4
;;;									#button {Dagger} 5
;;;									#button {Mace} 6
;;;									#button {Rifle} 7
;;;									#button {Derringer} 8


									{Examinar}

									#button {Armario} 1
									#button {Arma} 2
									#button {boomerang} 3
									#button {Cutlass} 4
									#button {Daga} 5
									#button {Mazo} 6
;;;									#button {Rifle} 7
;;;									#button {Derringer} 8																			
								)
							)
							(switch temp7
								(1 		
										(event claimed: TRUE)
										(Print 31 5)
								)
								(2
									(DoVerb {examine weapon})
							
								)
								(3
									(DoVerb {examine boomerang})
									(if (< (ego distanceTo: gundoor) 30)
										(= local4 1)
										(gundoor setScript: cabinetDrawer)
									else
										(NotClose)
							)
							
								)	
								(4 		
									(DoVerb {Examine Cutlass})
								)
								(5
									(DoVerb {examine Dagger})
							
								)
								(6
									(DoVerb {examine mace})
							
								)
								(7 		
									(DoVerb {Examine rifle})
								)
								(8
									(DoVerb {examine derringer})
							
								)
																							
								(else
									(event claimed: FALSE)
								)
							)
						

						)
						(995
							(= temp8
										(PrintSpecial
		;;;									{Get}
		;;;									#button {Weapon} 1
		;;;									#button {boomerang} 2
		;;;									#button {Cutlass} 3
		;;;									#button {Dagger} 4
		;;;									#button {Mace} 5
;;;		;;;									#button {Rifle} 6
;;;		;;;									#button {Derringer} 7
		;;;									#button {Close armoire} 8
											{Coger}
											#button {Arma} 1
											#button {boomerang} 2
											#button {Cutlass} 3
											#button {Daga} 4
											#button {Mazo} 5
;;;											#button {Rifle} 6
;;;											#button {Derringer} 7

												
										)
										
									)

									(switch temp8	
										(1 	
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get weapon})
											
											
										)
										(2
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get boomerang})
									
										)
										(3
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get Cutlass})
									
										)
										(4
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get Dagger})
									
										)
										(5
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get Mace})
									
										)
										(6
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get Rifle})
									
										)
										(7
;;;											(gundoor setScript: cabinetDrawer)
											(DoVerb {get Derringer})
									
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






						(if (and (ClickedOnObj gundoor (event x?) (event y?)) 
							(== opendoor 0))
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(if (Btst 47)
								(Print 31 3)
							else
								(Print 31 4)
							)
						)							
						(995
								(cond 
					((< (ego x?) 160)
						(switch local4
							(1 (Print 31 23))
							(2 (Print 31 24))
							(3 (Print 31 25))
							(4 (Bset 27) (Print 31 26))
							(5 (Bset 28) (Print 31 17))
							(0
								(Printf 31 27
									(if (>= currentAct 5)
										{,}
									else
										{, a pearl-handled dagger,}
										{, una daga tallada con perlas,}
									)
								)
								(if (>= currentAct 5) (Bset 28) else (Bset 27))
							)
						)
					)
					(local5 (Print 31 28) (= local5 0))
					(else (Print 31 29))
				)
;;;				(= cycles 1)
				(= opendoor 1)
			)
							
							
						
						(else
								(event claimed: FALSE)
							)
						)
					)		



;;;
;;;				(if (ClickedOnObj cabDoor (event x?) (event y?)) 
;;;					(event claimed: TRUE)
;;;					(switch theCursor
;;;						(998
;;;							(= temp7
;;;								(PrintSpecial
;;;;;;									{Examine}
;;;
;;;;;;									#button {Armoire} 1
;;;;;;									#button {Weapon} 2
;;;;;;									#button {boomerang} 2
;;;;;;									#button {Cutlass} 4
;;;;;;									#button {Dagger} 5
;;;;;;									#button {Mace} 6
;;;									#button {Rifle} 7
;;;									#button {Derringer} 8
;;;
;;;
;;;									{Examinar}
;;;
;;;									#button {Armario} 1
;;;									#button {Arma} 2
;;;									#button {boomerang} 3
;;;									#button {Cutlass} 4
;;;									#button {Daga} 5
;;;									#button {Mazo} 6
;;;									#button {Rifle} 7
;;;									#button {Derringer} 8																			
;;;								)
;;;							)
;;;							(switch temp7
;;;								(1 		
;;;										(event claimed: TRUE)
;;;										(Print 31 5)
;;;								)
;;;								(2
;;;									(DoVerb {examine weapon})
;;;							
;;;								)
;;;								(3
;;;									(DoVerb {examine boomerang})
;;;							
;;;								)	
;;;								(4 		
;;;									(DoVerb {Examine Cutlass})
;;;								)
;;;								(5
;;;									(DoVerb {examine Dagger})
;;;							
;;;								)
;;;								(6
;;;									(DoVerb {examine mace})
;;;							
;;;								)
;;;								(7 		
;;;									(DoVerb {Examine rifle})
;;;								)
;;;								(8
;;;									(DoVerb {examine derringer})
;;;							
;;;								)
;;;																							
;;;								(else
;;;									(event claimed: FALSE)
;;;								)
;;;							)
;;;						
;;;
;;;						)
;;;						(995
;;;						(= temp7
;;;								(PrintSpecial
;;;;;;									{Cabinet}
;;;;;;									#button {Open} 1
;;;;;;									#button {Close} 2
;;;
;;;									{Armario}
;;;									#button {Abrir} 1
;;;									#button {Cerrar} 2
;;;										
;;;								)
;;;							)
;;;							(switch temp7
;;;								(1 		
;;;									(DoVerb {open armoire})
;;;									(event claimed: TRUE)
;;;									(= temp8
;;;										(PrintSpecial
;;;		;;;									{Get}
;;;		;;;									#button {Weapon} 1
;;;		;;;									#button {boomerang} 2
;;;		;;;									#button {Cutlass} 3
;;;		;;;									#button {Dagger} 4
;;;		;;;									#button {Mace} 5
;;;		;;;									#button {Rifle} 6
;;;		;;;									#button {Derringer} 7
;;;		;;;									#button {Close armoire} 8
;;;											{Coger}
;;;											#button {Arma} 1
;;;											#button {boomerang} 2
;;;											#button {Cutlass} 3
;;;											#button {Daga} 4
;;;											#button {Mazo} 5
;;;											#button {Rifle} 6
;;;											#button {Derringer} 7
;;;											#button {Cerrar armario} 8
;;;												
;;;										)
;;;									)
;;;									(switch temp8	
;;;										(1 	
;;;											
;;;											(DoVerb {get weapon})
;;;											
;;;											
;;;										)
;;;										(2
;;;											(DoVerb {get boomerang})
;;;									
;;;										)
;;;										(3
;;;											(DoVerb {get Cutlass})
;;;									
;;;										)
;;;										(4
;;;											(DoVerb {get Dagger})
;;;									
;;;										)
;;;										(5
;;;											(DoVerb {get Mace})
;;;									
;;;										)
;;;										(6
;;;											(DoVerb {get Rifle})
;;;									
;;;										)
;;;										(7
;;;											(DoVerb {get Derringer})
;;;									
;;;										)
;;;										(8
;;;											(DoVerb {close armoire})
;;;									
;;;										)																																																															
;;;										(else
;;;											(event claimed: FALSE)
;;;										)
;;;									)
;;;								)
;;;							
;;;						
;;;							)
;;;						)	
;;;						(else
;;;									(event claimed: FALSE)
;;;								)
;;;						
;;;						)
;;;						)
;;;
;;;
;;;

				(if (ClickedOnObj derringer (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(995					
																(= temp7
								(PrintSpecial
;;;									{Derringer}
;;;									#button {Break case} 1
;;;									#button {get derringer} 2

									{C{pula}
									#button {Romper} 1
									#button {Coger derringer} 3											

								)
							)
							(switch temp7
								(1 		
									(DoVerb {break case})
								)
								(2
									(DoVerb {get derringer})
							
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
						
		(if (and (ClickedOnObj cabDoor (event x?) (event y?)) 
							(== opendoor2 1))
					(event claimed: TRUE)
					(switch theCursor
						(998		
							(DoVerb {look rifle})
							(event claimed: TRUE)
;;;							(Print {You only see a rifle.})
							(Print {Simplemente ves un rifle.})
							
						)
						(995
							(DoVerb {get rifle})
						)
						(else
								(event claimed: FALSE)
							)
						)
					)			
								
								
						
	(if (and (ClickedOnObj cabDoor (event x?) (event y?)) 
							(== opendoor2 0))
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(if (Btst 47)
								(Print 31 3)
							else
								(Print 31 4)
							)
						)							
						(995
							(DoVerb {open armoire})	
								
							(= opendoor2 1)
			)
							
							
						
						(else
								(event claimed: FALSE)
							)
						)
					)		
					
						
						
						
						)
					)
			
					
		(super handleEvent: event)
		(if (event claimed?) (return))
		(DisposeScript SAVE)

		(if (== (event type?) saidEvent)
			(if
				(and
					global208
					(Said
						'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
					)
				)
				(DisposeScript SAVE)
				(self setScript: (ScriptID 243 0))
				((self script?) handleEvent: event)
				(if (event claimed?) (return))
			)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '[<around,at][/room]')
							(Print 31 0)
						)
						((Said '/boomerang[<australian]')
							(if (< (ego distanceTo: gundoor) 30)
								(= local4 1)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose)
							)
						)
						((Said '/cutlass[<steel]')
							(if (< (ego distanceTo: gundoor) 30)
								(= local4 2)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose)
							)
						)
						((Said '/mace[<antique]')
							(if (< (ego distanceTo: gundoor) 30)
								(= local4 3)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose)
							)
						)
						((Said '/dagger[<pearl]')
							(if (< (ego distanceTo: gundoor) 30)
								(if (>= currentAct 5)
									(= local4 5)
								else
									(= local4 4)
								)
								(gundoor setScript: cabinetDrawer)
							else
								(NotClose)
							)
						)
						((Said '/rifle')
							(if (< (ego distanceTo: cabDoor) 30)
								(= local5 1)
								(cabDoor setScript: cabinetDrawer)
							else
								(NotClose)
							)
						)
						((Said '/top/armoire')
							(if (< (ego x?) 160)
								(Print 31 1)
							else
								(Print 31 2)
							)
						)
						((Said '/armoire')
							(cond 
								((< (ego distanceTo: gundoor) 80)
									(if (Btst 47)
										(Print 31 3)
									else
										(Print 31 4)
									)
								)
								((< (ego distanceTo: cabDoor) 80)
									(Print 31 5)
								)
								(else
									(NotClose)
								)
							)
						)
						((Said '/weapon')
							(Print 31 6)
						)
						((Said '/door')
							(Print 31 7)
						)
						((Said '<above,above/fireplace')
							(Print 31 8)
						)
						((Said '/mantel')
							(Print 31 9)
						)
					)
				)
				((Said 'move/case')
					(Print 31 10)
				)
				((Said 'open/case')
					(if (< currentAct 6)
						(Print 31 11)
					else
						(Print 31 12)
					)
				)
				((Said 'unbar/case')
					(if (< currentAct 6)
						(Print 31 13)
					else
						(Print 31 14)
					)
				)
				((Said 'get>')
					(cond 
						((Said '/weapon')
							(Print 31 15)
						)
						((Said '/boomerang[<australian]')
							(Print 31 16)
						)
						((Said '/cutlass[<steel]')
							(Print 31 16)
						)
						((Said '/mace[<antique]')
							(Print 31 16)
						)
						((Said '/dagger[<pearl]')
							(if (>= currentAct 5)
								(Bset 28)
								(Print 31 17)
							else
								(Bset 27)
								(Print 31 16)
							)
						)
						((Said '/rifle')
							(Print 31 18)
						)
						((Said '/derringer')
							(if (< currentAct 6)
								(Bset 25)
								(Print 31 19)
							else
								(Bset 26)
								(Print 31 17)
							)
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

(instance spin of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(sphere cycleSpeed: 0 setCycle: Forward)
				(= seconds 4)
			)
			(1
				(sphere cycleSpeed: 1)
				(= seconds 2)
			)
			(2
				(sphere cycleSpeed: 2)
				(= seconds 2)
			)
			(3
				(sphere setCycle: 0 stopUpd:)
				(Print 31 20)
				(= local0 0)
				(HandsOn)
				(sphere setScript: 0)
			)
		)
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

(instance cabinetDrawer of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= theTalker talkLILLIAN)
					(switch local7
						(0 (Say 1 31 21))
						(else  (Say 1 31 22))
					)
					(++ local7)
					(client setScript: 0)
				else
					(HandsOff)
					(ego loop: 3)
					(cond 
						(local9 (= state 2) (= cycles 1))
						((not (Btst 47)) (client setCycle: EndLoop self))
						(else (= cycles (= state 1)))
					)
				)
			)
			(1 (= cycles 8))
			(2
				(cond 
					((< (ego x?) 160)
						(switch local4
							(1 (Print 31 23))
							(2 (Print 31 24))
							(3 (Print 31 25))
							(4 (Bset 27) (Print 31 26))
							(5 (Bset 28) (Print 31 17))
							(0
								(Printf 31 27
									(if (>= currentAct 5)
										{,}
									else
										{, a pearl-handled dagger,}
										{, una daga tallada con perlas,}
									)
								)
								(if (>= currentAct 5) (Bset 28) else (Bset 27))
							)
						)
					)
					(local5 (Print 31 28) (= local5 0))
					(else (Print 31 29))
				)
				(= cycles 1)
			)
			(3 (client setCycle: BegLoop self))
			(4
				(client stopUpd:)
				(= local9 (= local1 0))
				(Bclr 47)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego illegalBits: 0)
				(= cycles 2)
			)
			(1
				(if (< (ego x?) 87)
					(ego setMotion: MoveTo 95 121 self)
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
				(ego setMotion: MoveTo (- (ego x?) 50) 121)
			)
		)
	)
)

(instance rhino of RPicView
	(properties
		y 32
		x 207
		view 131
		priority 5
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((Said 'examine<in/rhino,head')
				(Print 31 30)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/rhino,head'))
				(event claimed: TRUE)
				(Print 31 8)
			)
			((Said 'get/rhino,head')
				(Print 31 31)
			)
		)
	)
)

(instance firetools of PicView
	(properties
		y 87
		x 226
		view 131
		cel 10
		priority 5
	)
)

(instance logs of RPicView
	(properties
		y 86
		x 206
		view 131
		cel 9
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {fireplace})
		)
	)
)

(instance bookcase of PicView
	(properties
		y 114
		x 88
		view 131
		cel 6
		priority 7
		signal $4000
	)
)

(instance aligator of RPicView
	(properties
		y 42
		x 127
		view 131
		cel 1
		priority 5
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((or (MousedOn self event shiftDown) (Said 'examine/alligator'))
				(event claimed: TRUE)
				(Print 31 1)
			)
			((Said 'get/bird,alligator')
				(Print 31 32)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 118
		x 263
		view 131
		loop 1
		cel 1
		priority 8
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance wingback of RPicView
	(properties
		y 112
		x 138
		view 131
		loop 1
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

(instance chair of RPicView
	(properties
		y 165
		x 169
		view 131
		loop 1
		priority 12
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 105
		x 167
		view 131
		cel 5
		priority 7
		signal ignrAct
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
		y 105
		x 241
		view 131
		cel 5
		priority 6
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance hawk of RPicView
	(properties
		y 43
		x 295
		view 131
		cel 2
		priority 5
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((or (MousedOn self event shiftDown) (Said 'examine/bird'))
				(event claimed: TRUE)
				(Print 31 2)
			)
		)
	)
)

(instance globe of RPicView
	(properties
		y 166
		x 35
		view 131
		cel 8
		priority 13
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((Said 'move/globe')
				(Print 31 33)
			)
			((Said 'examine<below/globe')
				(Print 31 34)
			)
			((Said 'examine<in/globe')
				(Print 31 35)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/globe'))
				(event claimed: TRUE)
				(Print 31 36)
			)
			((Said 'get/globe')
				(Print 31 37)
			)
			((Said 'open/globe')
				(Print 31 35)
			)
			((Said 'rotate,spin/globe')
				(if (== local0 0)
					(if (< (ego distanceTo: sphere) 30)
						(sphere setScript: spin)
					else
						(NotClose)
					)
				else
					(Print 31 38)
				)
			)
		)
	)
)

(instance crossbow of RPicView
	(properties
		y 77
		x 85
		view 131
		cel 3
		priority 7
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/crossbow[<antique]')
				)
				(event claimed: TRUE)
				(Print 31 39)
			)
			((Said 'get/crossbow[<antique]')
				(Print 31 16)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 53
		x 87
		view 131
		loop 2
		priority 5
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
		y 65
		x 63
		view 131
		loop 2
		priority 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance tomahawk of RPicView
	(properties
		y 89
		x 59
		view 131
		cel 4
		priority 9
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/ax[<feathered]')
				)
				(event claimed: TRUE)
				(Print 31 40)
			)
			((Said 'get/ax[<feathered]')
				(Print 31 16)
			)
		)
	)
)

(instance Spear of RFeature
	(properties
		nsTop 29
		nsLeft 186
		nsBottom 49
		nsRight 232
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/spear')
				(Print 31 41)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/spear'))
				(event claimed: TRUE)
				(Print 31 42)
			)
		)
	)
)

(instance Desk of RFeature
	(properties
		nsTop 118
		nsLeft 146
		nsBottom 150
		nsRight 208
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/desk,(drawer[<desk])')
				(Print 31 43)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/desk'))
				(event claimed: TRUE)
				(if (< currentAct 6)
					(Print 31 44)
				else
					(Print 31 45)
				)
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 20
		nsLeft 146
		nsBottom 85
		nsRight 178
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
		nsLeft 247
		nsBottom 85
		nsRight 277
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {window})
		)
	)
)

(instance Bdoor of Prop
	(properties
		y 127
		x 66
		view 201
		loop 2
		priority 9
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {door})
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 116
		x 76
		view 201
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {door})
		)
	)
)

(instance sphere of Prop
	(properties
		y 154
		x 36
		view 131
		loop 3
	)
)

(instance gundoor of Prop
	(properties
		y 83
		x 131
		view 131
		loop 4
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'move/armoire')
				(Print 31 46)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(if (Btst 47)
					(Print 31 3)
				else
					(Print 31 4)
				)
			)
		)
	)
)

(instance cabDoor of Prop
	(properties
		y 89
		x 286
		view 131
		loop 5
	)
	
	(method (handleEvent event)
		(cond 
			((Said '(examine<in),open/armoire,(door<armoire)>')
				(= local4 0)
				(cond 
					((< (ego distanceTo: gundoor) 30)
						(if (and (Said 'open') (Btst 47))
							(AlreadyOpen)
						else
							(gundoor setScript: cabinetDrawer)
						)
					)
					((< (ego distanceTo: cabDoor) 30)
						(cabDoor setScript: cabinetDrawer)
					)
					(else
						(NotClose)
					)
				)
				(event claimed: TRUE)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(Print 31 5)
			)
			((Said 'close/armoire,(door<armoire)')
				(cond 
					((or (< (ego distanceTo: cabDoor) 30) (not (Btst 47)))
						(AlreadyClosed)
					)
					((< (ego distanceTo: gundoor) 30)
						(= local9 1)
						(gundoor setScript: cabinetDrawer)
					)
					(else
						(NotClose)
					)
				)
			)
		)
	)
)

(instance derringer of Prop
	(properties
		y 124
		x 195
		view 131
		loop 1
		cel 3
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'break/glass,case')
				(if (< currentAct 6)
					(Bset 25)
					(Print 31 47)
				else
					(Bset 26)
					(Print 31 14)
				)
			)
			((Said 'feel<in/case')
				(Bset 25)
				(Print 31 48)
			)
			((Said 'get/glass,case')
				(if (< currentAct 6)
					(Bset 25)
					(Print 31 49)
				else
					(Print 31 50)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/case[<glass]')
				)
				(event claimed: TRUE)
				(if (< currentAct 6)
					(Bset 25)
					(Print 31 51)
				else
					(Bset 26)
					(Print 31 52)
				)
			)
			((Said 'find,examine/derringer')
				(if (< currentAct 6)
					(Bset 25)
					(Print 31 53)
				else
					(Bset 26)
					(Print 31 17)
				)
			)
		)
	)
)

(instance Shadow of Actor
	(properties
		view 110
	)
)

(instance mySound of Sound
	(properties
		number 43
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
				(ego ignoreActors: FALSE setMotion: MoveTo 99 122)
				(Fdoor setCycle: BegLoop)
				(Bdoor setCycle: BegLoop self)
				(mySound number: 44 play:)
			)
			(2
				(if (and (!= global154 1) (not local6))
					(User canInput: TRUE)
				)
				(User canControl: TRUE)
				(Bdoor stopUpd:)
				(Fdoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)
