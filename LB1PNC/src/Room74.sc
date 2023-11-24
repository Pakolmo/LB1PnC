;;; Sierra Script 1.0 - (do not remove this comment)
(script# 74) ;244  261 273
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use PncMenu)

(public
	Room74 0
)
(synonyms
	(stair upstair)
	(armoire armoire closet)
	(fifi person girl)
	(decanter bottle)
)

(local
	local0
	talkCount
	local2
	local3
	local4
	theCSound
	local6
	local7
	saveVolume
	local9
	local10
	temp7
)
(procedure (localproc_000c)
	(if local7
		(= local7 0)
		(= currentPalette 0)
		(DrawPic 174 WIPERIGHT TRUE 0)
		(DrawPic 74 WIPERIGHT FALSE 0)
		(if (and (>= currentAct 2) (< currentAct 5))
			(addToPics add: glasses)
			(Room74 setFeatures: glasses)
		)
		(if (>= currentAct 2)
			(addToPics add: decanter)
			(Room74 setFeatures: decanter)
		)
		(addToPics
			add:
				wardrobe
				sofa
				table1
				mirror
				chair1
				chair2
				table2
				phono
				bed
				photo
			eachElementDo: #init
			doit:
		)
		(Room74
			setFeatures:
				sofa
				table1
				mirror
				wardrobe
				chair1
				chair2
				table2
				bed
				photo
				phono
		)
		(cast eachElementDo: #show)
	)
)

(procedure (localproc_00ed)
	(if (not local7)
		(= local7 1)
		(= currentPalette 1)
		(DrawPic 174 WIPELEFT TRUE 1)
		(addToPics dispose:)
		(features dispose:)
		(cast eachElementDo: #hide)
		(ShowMenu) ;prevent menu from disapearing after (cast eachElementDo: #hide)
		(DrawPic 74 WIPELEFT FALSE 0)
		(door show:)
		(lamp2 show:)
		(ego show:)
	)
)

(instance Room74 of Room
	(properties
		picture 74
		curPic 74
	)
	
	(method (init)
		(= south 47)
		(= west 76)
		(= saveVolume (DoSound ChangeVolume))
		(Load PICTURE 174)
		(Load PICTURE 74)
		(super init:)
		(= overlays 174)
		(cond 
			((== prevRoomNum 47)
				(ego setPri: -1 posn: 42 187)
			)
			((!= prevRoomNum 64)
				(ego posn: 6 98)
			)
			(else
				(= saveVolume (DoSound ChangeVolume))
			)
		)
		(door loop: (if (> prevRoomNum 74) 3 else 6))
		(if (and (>= currentAct 2) (< currentAct 5))
			(addToPics add: glasses)
			(self setFeatures: glasses)
		)
		(if (>= currentAct 2)
			(if (< currentAct 6)
				(addToPics add: decanter)
				(self setFeatures: decanter)
			)
			(if (and (& deadGuests deadLILLIAN) (not (ego has: iSkeletonKey)))
				(door cel: (door lastCel:) ignoreActors: TRUE)
;;;				(|= global117 $8000)
				(= global117 (| global117 $8000))
			)
		)
		(Load VIEW 56)
		(LoadMany SOUND 43 48)
		(if howFast
			(lamp1 setPri: 11 setCycle: Forward ignoreActors: TRUE init:)
			(lamp2 setPri: 13 setCycle: Forward ignoreActors: TRUE init:)
		else
			(lamp1 setPri: 11 ignoreActors: TRUE init: stopUpd:)
			(lamp2 setPri: 13 ignoreActors: TRUE init: stopUpd:)
		)
		(if (& global117 $8000) (door loop: 6 cel: 3))
		(door setPri: 7 ignoreActors: TRUE init: stopUpd:)
		(Tswing setPri: 6 ignoreActors: TRUE init: stopUpd:)
		(Bswing setPri: 8 ignoreActors: TRUE init: stopUpd:)
		(= gDoor record)
		(switch currentAct
			(1
				(if (== global126 1)
					(self setRegions: 244)
				)
			)
			(2
				(self setRegions: 261)
			)
			(4
				(= local4 1)
				(Load SOUND 223)
				(= theCSound cSound)
				(LoadMany 143 243 371)
				(LoadMany VIEW 474 928)
				(= global208 16)
				(= [global377 4] 371)
				(if (or (== prevRoomNum 64) (>= global192 64))
					(if (== global192 64)
						(Load VIEW 471)
						(Fifi view: 471 posn: 271 104 loop: 1 init:)
						(self setScript: finishDress)
					else
						(Fifi
							view: 474
							setPri: 13
							illegalBits: 0
							posn: 242 128
							loop: 0
							cycleSpeed: 2
							init:
						)
						(FifiButt setPri: 14 init: stopUpd:)
						(= local10 1)
						(self setScript: primp)
					)
				else
					(Fifi
						view: 462
						loop: 0
						cel: 0
						illegalBits: 0
						posn: 118 76
						init:
						hide:
					)
				)
			)
			(5
				(if
					(and
						(not (& deadGuests deadFIFI))
						(not (& deadGuests deadLILLIAN))
					)
					(= local4 1)
					(self setRegions: 273)
					(flowers init: stopUpd:)
				)
			)
		)
		(if (== prevRoomNum 64)
			(= local7 1)
			(localproc_000c)
		else
			(localproc_00ed)
		)
		(if (not (& global117 $8000))
;;;			(ego illegalBits: (| cWHITE cCYAN))
			(ego illegalBits: -32760)
		else
;;;			(ego illegalBits: cWHITE)
			(ego illegalBits: -32768)
		)
		(ego view: 0 init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(if (== prevRoomNum 47)
				(Print 74 0)
			else
				(Print 74 1)
			)
		)
		(super doit:)
		(if
			(or
				(and (& (ego onControl: FALSE) cCYAN) (& deadGuests deadLILLIAN))
				(& (ego onControl: FALSE) cBLUE)
			)
			(Bclr 46)
			(curRoom newRoom: 75)
		)
		(cond 
			((ego inRect: -10 0 58 100)
				(= local2 3)
			)
			((ego inRect: 0 100 64 200)
				(if (!= local2 1)
					(= local2 1)
					(localproc_00ed)
					(DoSound ChangeVolume 0)
					(Room74 picture: 74)
					(curRoom setRegions: 950) ;add
				)
			)
			(else
				(= local2 2)
				(DoSound ChangeVolume saveVolume)
				(localproc_000c)
				(if (not global100)
					(= global100 1)
					(Print 74 2)
				)
				(if (and (== currentAct 4) (< global192 64) (not local6))
					(++ local6)
					(HandsOff)
					(Bset 20)
					(self setScript: startDress)
				)
			)
		)
		(if
		(and (& (ego onControl: origin) cRED) (== local0 0))
			(= local0 1)
			(Tswing cel: 1 forceUpd:)
			(Bswing cel: 1 forceUpd:)
		)
		(if (& (ego onControl: origin) cYELLOW)
			(= local3 1)
			(ego setPri: 5)
		else
			(= local3 0)
			(ego setPri: -1)
		)
		(if
		(and (& (ego onControl: origin) cMAGENTA) (== local0 0))
			(= local0 1)
			(Tswing cel: 3 forceUpd:)
			(Bswing cel: 3 forceUpd:)
		)
		(if
			(and
				(or
					(& (ego onControl: origin) cBLACK)
					(& (ego onControl: origin) cYELLOW)
				)
				(== local0 1)
			)
			(Tswing setCycle: EndLoop)
			(Bswing setCycle: EndLoop)
			(= local0 0)
		)
		(cond 
			((< (ego x?) 58)
				(= vertAngle 0)
			)
			((< (ego x?) 180)
				(= vertAngle 157)
			)
			(else (= vertAngle 140))
		)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(DisposeScript PATH)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(DisposeScript SAVE)
		
		
		
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
				(if (ClickedOnPicView wardrobe (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(DoVerb {open armoire}) 
						)
						(998
							(DoVerb {examine armoire}) 
						)
						(else
							(event claimed: FALSE)
						)
				
					)
					
				)							
				(if (ClickedOnPicView sofa (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(DoVerb {examine couch}) 
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
							(event claimed: TRUE)
							(Print 74 18) 
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
							(= temp7
												(Print
;;;													{Bed}
;;;													#button {Examine} 1
;;;													#button {Examine below} 2	
													{Cama}
													#button {Examinar} 1
													#button {Mirar debajo} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine bed})
												)
												(2
														(event claimed: TRUE)
														(DoLook {bed})
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


				(if (ClickedOnPicView mirror (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor	
						(998
							(= temp7
												(Print
;;;													{Mirror}
;;;													#button {reflection} 1
;;;													#button {Examine below} 2	
;;;													#button {Examine} 3
;;;													#button {Get} 4
													{Espejo}
													#button {Reflejo} 1
													#button {Mirar debajo} 2								
													#button {Mirar} 3
													#button {Coger} 4
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine in mirror})
												)
												(2
													(DoVerb {examine below mirror})
												)
												(3
													(DoVerb {examine mirror})
												)
												(4
													(DoVerb {get mirror})
												)
												(else
														(event claimed: FALSE)
												)
											)
						)
						(995
							(DoVerb {open mirror})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	

				(if (or (ClickedOnPicView chair1 (event x?) (event y?)) 
					(ClickedOnPicView chair2 (event x?) (event y?)) )
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
				(if (ClickedOnPicView table2 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(998
									(if
										(and
											(>= currentAct 2)
											(< currentAct 6)
											(or (MousedOn self event shiftDown) (Said 'examine/nightstand'))
										)
										(if (== currentAct 5)
											(if local4
												(Print 74 26)
											else
												(Print 74 27)
											)
										else
											(Print 74 28)
										)
										(event claimed: TRUE)
									)
									(if (MousedOn self event shiftDown)
										(event claimed: TRUE)
										(DoLook {table})
									)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (ClickedOnPicView glasses (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(= temp7
												(Print
;;;													{Glass}
;;;													#button {Get} 1
;;;													#button {Examine in} 2	
													{Vaso}
													#button {Coger} 1
													#button {Mirar dentro} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {get glass})
												)
												(2	
													(DoVerb {examine in glass})							
												)
												(else
														(event claimed: FALSE)
												)
											)
						)
						(998
							(DoVerb {examine glass})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)
				
				(if (ClickedOnPicView decanter (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(604 ;monocle
							(DoVerb {examine fingerprint})
						)
						
						
						(998		
						(= temp7
												(Print
;;;													{Decanter}
;;;													#button {Examine in} 1
;;;													#button {Examine} 2	
													{Vaso}
													#button {Coger} 1
													#button {Mirar dentro} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {get decanter})
												)
												(2	
													(DoVerb {examine in decanter})							
												)
												(else
														(event claimed: FALSE)
												)
											)
						)
						(995
							(DoVerb {examine decanter})	
						)				
						(else
							(event claimed: FALSE)
							)
						)
					)
					(if (ClickedOnPicView photo (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
							(event claimed: TRUE)
							(DoLook {picture})
						)
						(else
							(event claimed: FALSE)
							)
						)
					)							
					(if (ClickedOnPicView phono (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(998
							(= temp7
												(Print
;;;													{Gramophone}
;;;													#button {Examine gramophone} 1
;;;													#button {Examine record} 2	
													{Gram/fono}
													#button {Examinar gram/fono} 1
													#button {Examinar disco} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine record})
												)
												(2	
													(DoVerb {examine gramophone})							
												)
												(else
														(event claimed: FALSE)
												)
											)
						)
						(995
													(= temp7
												(Print
;;;													{Phono}
;;;													#button {Cease} 1
;;;													#button {Play} 2	
													{Fon/grafo}
													#button {Parar} 1
													#button {Tocar} 2								
													
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {cease record})
												)
												(2	
													(DoVerb {play music})							
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
						(if (ClickedOnObj flowers (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {get blossom})
						)
						(998
							(DoVerb {examine blossom})
						)
						(else
							(event claimed: FALSE)
							)
						)
					)	
					(if (or (ClickedOnObj Tswing (event x?) (event y?)) ;twice
							(ClickedOnObj Tswing (event x?) (event y?)) )
					(event claimed: TRUE)
					(switch theCursor
						(995
									(= temp7
												(Print
;;;													{Cloth}
;;;													#button {Change cloth} 1
;;;													#button {Get cloth} 2	
;;;													#button {Close curtain} 3	


													{Ropa}
													#button {Cambiar ropa} 1
													#button {Coger ropa} 2								
													#button {Cerrar cortina} 3
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {change cloth})
												)
												(2	
													(DoVerb {get cloth})							
												)
												(3
													(DoVerb {close curtain})							
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
					(if (ClickedOnObj lamp2 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor
						(995					
							(DoVerb {get lamp})
						)
						(998
							(event claimed: TRUE)
							(DoLook {lamp})
						)
						(else
							(event claimed: FALSE)
						)
					)
				)		

				(if (ClickedOnObj Tswing (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998
;;;							(DoVerb {examine door swinging})
									(if
;;;										(and
											(== local2 2)
														
;;;										)
										(Print 74 65)
										(event claimed: TRUE)
									)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
				
					(if (ClickedOnObj Bswing (event x?) (event y?)) 
					(event claimed: TRUE)
					(switch theCursor
						(998	
	
							(if

									(== local2 2)
									
									

								
								(Print 74 65)
								(event claimed: TRUE)
							)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)	
				(if (and (ClickedOnObj door (event x?) (event y?)) 
					(== prevRoomNum 47) )
					(event claimed: TRUE)
					(switch theCursor
						(995
	(= temp7
												(Print
;;;													{Door}
;;;													#button {Open} 1
;;;													#button {Close} 2	
;;;													#button {Bang} 3
;;;													#button {Enter} 4
													{Puerta}
													#button {Abrir} 1
													#button {Cerrar} 2								
													#button {Golpear} 3
													#button {Entrar} 4
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {open door})
												)
												(2	
													(DoVerb {close door})							
												)
												(3	
													(DoVerb {bang door})							
												)
												(4	
													(DoVerb {enter attic})							
												)																								
												(else
														(event claimed: FALSE)
												)
											)
						)									
						(620 ;skeletonkey
							(DoVerb {unbar door})	
						)
						(998
							(= temp7
												(Print
;;;													{Door}
;;;													#button {Examine door} 1
;;;													#button {Examine keyhole} 2	
													{Door}
													#button {Examinar puerta} 1
													#button {Examinar cerradura} 2								
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine door attic})
												)
												(2	
													(DoVerb {examine keyhole})							
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
				(if (and (ClickedOnObj door (event x?) (event y?)) 
					(!= prevRoomNum 47) )
					(event claimed: TRUE)
					(switch theCursor
						(995
							(DoVerb {unbar door})
							(event claimed: TRUE)
							(DoVerb {open door})
						)
						(620 ;skeletonkey
							(DoVerb {unbar door})	
						)
						(998
							(= temp7
												(Print
;;;													{Door}
;;;													#button {Examine door} 1
;;;													#button {Examine keyhole} 2	
													{Door}
													#button {Examinar puerta} 1
													#button {Examinar cerradura} 2								
												)
											)
											(switch temp7
												(1 ;
													(DoVerb {examine door attic})
												)
												(2	
													(DoVerb {examine keyhole})							
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
									
				(if (ClickedOnObj Fifi (event x?) (event y?)) 
;;;					(not local7))
					(event claimed: TRUE)
					(switch theCursor
						(998	
								(if (not (& global207 $0010))
									(= global207 (| global207 $0010))						
			;;;						(|= global207 $0010)
									(Say 0 74 73)
								else
									(Print 74 74)
								)	
						)
				
					(602 ;necklace_
						(DoVerb {tell fifi about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell fifi about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell fifi about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell fifi about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell fifi about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell fifi about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell fifi about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell fifi about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell fifi about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell fifi about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell fifi about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell fifi about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell fifi about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell fifi about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell fifi about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell fifi about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell fifi about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell fifi about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell fifi about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell fifi about diary})						
					)
					(621 ;crank_
						(DoVerb {tell fifi about crank})						
					)
					(612 ;cane_
						(DoVerb {tell fifi about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell fifi about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell fifi about handkerchief})
					)
											
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
												(= temp7
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about gertie})
							)
							(2
								(DoVerb {tell fifi about gertie})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(931 ;Celie
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about Celie})
							)
							(2
								(DoVerb {tell fifi about Celie})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about gloria})
							)
							(2
								(DoVerb {tell fifi about gloria})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(933 ;Ethel
								
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about ethel})
							)
							(2
								(DoVerb {tell fifi about ethel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(= temp7
														(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about fifi})
							)
							(2
								(DoVerb {tell fifi about fifi})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about lillian})
							)
							(2
								(DoVerb {tell fifi about lillian})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)																				
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about Clarence})
							)
							(2
								(DoVerb {tell fifi about clarence})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(937 ;Feels
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about Wilbur})
							)
							(2
								(DoVerb {tell fifi about Wilbur})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about rudolph})
							)
							(2
								(DoVerb {tell fifi about rudolph})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about colonel})
							)
							(2
								(DoVerb {tell fifi about colonel})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(= temp7
															(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about Jeeves})
							)
							(2
								(DoVerb {tell fifi about Jeeves})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)
		
							(941 ;Dog
								(event type: 1 claimed: 1)
							(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about beauregard})
							)
							(2
								(DoVerb {tell fifi about beauregard})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)												
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about polly})
							)
							(2
								(DoVerb {tell fifi about polly})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)				
							(943 ;Horse
								(event type: 1 claimed: 1)
								(= temp7	
							(Print
;;;								{Ask or Tell}
;;;								#button {Ask} 1
;;;								#button {Tell} 2
								{Preguntar o Hablar de}
								#button {Preguntar} 1
								#button {Hablar de} 2												
							)
						)
						(switch temp7
							(1 
								(DoVerb {ask fifi about blaze})
							)
							(2
								(DoVerb {tell fifi about blaze})
							)
						(else
							(event claimed: FALSE)
						)
					)
				)								
							
											
							
							
						(994	
							(DoVerb {hear Fifi})
						)							
						(996 ;talk
							(DoVerb {converse Fifi})
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
				(if
					(and
						(> (ego x?) 64)
						global208
						(Said 'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>')
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return TRUE))
				)
				(if (Said 'examine>')
					(cond 
						((Said '/room<dressing')
							(if (and (not local7) 2)
								(Print 74 3)
							else
								(DontSee)
							)
						)
						((Said '/bedroom')
							(if 2
								(Print 74 2) 
							else
								(Print 74 4)
							)
						)
						((Said '[<around,at][/room]')
							(cond 
								(local3
									(Print 74 5)
								)
								((== local2 1)
									(Print 74 0)
								)
								((== local2 3)
									(Print 74 1)
								)
								((and (not (& deadGuests deadFIFI)) (== currentAct 5))
;;;									(|= deadGuests deadFIFI)
									(= deadGuests (| deadGuests deadFIFI))									
									(Print 74 6)
								)
								(else
									(Print 74 2)
								)
							)
						)
						((or (Said '<down') (Said '/downstair'))
							(cond 
								((== local2 1)
									(Print 74 7)
								)
								(local3
									(Print 74 5)
								)
								(local4
									(Print 74 8)
								)
								(else
									(event claimed: FALSE)
								)
							)
						)
						((or (Said '<up') (Said '/stair'))
							(if (== local2 1)
								(Print 74 0)
							else
								(event claimed: FALSE)
							)
						)
						((Said '/dormer')
							(if (== local2 2)
								(Print 74 9)
							else
								(event claimed: FALSE)
							)
						)
						((Said '/attic')
							(if (!= local2 3)
								(Print 74 10)
							else
								(Print 74 11)
							)
						)
						((Said '<below/carpet')
							(if (== local2 2)
								(Print 74 12)
							else
								(event claimed: FALSE)
							)
						)
						((Said '/window')
							(if (== local2 2)
								(Print 74 13)
							else
								(event claimed: FALSE)
							)
						)
						((Said '/curtain')
							(if (== local2 2)
								(Print 74 14)
							else
								(event claimed: FALSE)
							)
						)
					)
				)
			else
				FALSE
			)
		)
	)
	
	(method (newRoom n)
		(if (and (== theCSound cSound) (!= n 64))
			(theCSound stop:)
		)
		(Wait 1)
		(Wait 10)
		(= saveDisabled 0)
		(DoSound ChangeVolume saveVolume)
		(super newRoom: n)
	)
)

(instance startDress of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(record setCycle: Forward init:)
				(if (!= prevRoomNum 64)
					(theCSound number: 223 loop: -1 play:)
				)
				(Fifi show: view: 462 loop: 1 cel: 0 setCycle: EndLoop self)
			)
			(1
				(Fifi loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(2
				(Fifi
					view: 460
					setCycle: Walk
					setMotion: MoveTo 227 107 self
				)
			)
			(3
				(Tswing cel: 1 forceUpd:)
				(Bswing cel: 1 forceUpd:)
				(Fifi setMotion: MoveTo 241 107 self)
			)
			(4
				(Tswing cel: 0 forceUpd:)
				(Bswing cel: 0 forceUpd:)
				(Fifi setMotion: MoveTo 271 107 self)
			)
			(5 (curRoom newRoom: 64))
		)
	)
)

(instance finishDress of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(record setCycle: Forward init:)
				(= global192 74)
				(Fifi setCycle: Walk setMotion: MoveTo 245 107 self)
			)
			(1
				(Tswing cel: 3 forceUpd:)
				(Bswing cel: 3 forceUpd:)
				(Fifi setMotion: MoveTo 225 110 self)
			)
			(2
				(Tswing cel: 0 forceUpd:)
				(Bswing cel: 0 forceUpd:)
				(Fifi setMotion: MoveTo 175 110 self)
			)
			(3
				(Fifi setMotion: MoveTo 181 151 self)
			)
			(4
				(Fifi illegalBits: 0 setMotion: MoveTo 250 156 self)
			)
			(5
				(Fifi setScript: primp)
				(client setScript: 0)
			)
		)
	)
)

(instance primp of Script
	
	(method (doit)
		(super doit:)
		(if (and (!= prevRoomNum 64) local10)
			(if (> (ego x?) 65)
				(= local10 0)
				(theCSound number: 223 loop: -1 play:)
				(record setCycle: Forward init:)
			else
				(theCSound stop:)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(Fifi
					view: 474
					setPri: 13
					illegalBits: 0
					posn: 242 128
					loop: 0
					cycleSpeed: 2
					setCycle: EndLoop self
				)
				(FifiButt setPri: 14 init: stopUpd:)
			)
			(1
				(Fifi loop: 1 setCycle: Forward)
				(= seconds 3)
			)
			(2
				(Fifi loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(3
				(Fifi loop: 3 setCycle: Forward)
				(= seconds 3)
			)
			(4
				(Fifi loop: 0 cel: 1 setCycle: BegLoop self)
			)
			(5 (= seconds 8) (= state 12))
			(6
				(Fifi loop: 4 cel: 0 setCycle: EndLoop self)
			)
			(7
				(Fifi loop: 5 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(8
				(Fifi loop: 4 cel: 1 setCycle: BegLoop self)
			)
			(9 (= seconds 8) (= state 12))
			(10
				(Fifi loop: 6 cel: 0 setCycle: EndLoop self)
			)
			(11
				(Fifi loop: 7 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(12
				(Fifi loop: 6 cel: 1 setCycle: BegLoop self)
			)
			(13
				(if local9
					(switch (Random 1 3)
						(1 (= state -1))
						(2 (= state 5))
						(3 (= state 9))
					)
				)
				(= seconds 6)
			)
			(14
				(++ local9)
				(Fifi view: 478 loop: 0 cel: 0 setCycle: EndLoop self)
			)
			(15
				(Fifi loop: 1 setCycle: Forward)
				(= seconds 3)
			)
			(16
				(Fifi loop: 2 cel: 0 setCycle: EndLoop self)
			)
			(17
				(Fifi loop: 3 cel: 0 setCycle: Forward)
				(= seconds 3)
			)
			(18
				(Fifi loop: 2 cel: 3 setCycle: BegLoop self)
				(= state -1)
			)
		)
	)
)

(instance knockDoor of Script

	(method (doit)
		(if (== (myMusic prevSignal?) 11)
			(DoSound ChangeVolume 0)
			(= cycles 1)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMusic prevSignal: 0)
				(HandsOff)
				(ego view: 56 loop: 0 setCycle: EndLoop self)
			)
			(1
				(myMusic number: 48 loop: 1 priority: 15 play:)
				(DoSound ChangeVolume saveVolume)
				(ego loop: 2 setCycle: Forward)
			)
			(2
				(Print 74 15)
				(ego view: 56 loop: 0 cel: 3 setCycle: BegLoop self)
			)
			(3
				(HandsOn)
				(ego view: 0 setCycle: Walk loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 78
		x 84
		view 174
		loop 2
		cel 2
		priority 4
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/armoire')
				(Print 74 16)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(event claimed: TRUE)
				(Print 74 17)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 78
		x 138
		view 174
		loop 2
		cel 1
		priority 3
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {couch})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 79
		x 192
		view 174
		loop 2
		cel 7
		priority 3
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(Print 74 18)
		)
	)
)

(instance bed of RPicView
	(properties
		y 142
		x 232
		view 174
		loop 2
		priority 10
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<below/bed')
				(Print 74 19)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(DoLook {bed})
			)
		)
	)
)

(instance mirror of RPicView
	(properties
		y 158
		x 268
		view 174
		loop 2
		cel 3
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'examine<in/mirror')
					(Said 'examine/reflection')
				)
				(if (< (ego distanceTo: mirror) 80)
					(= theTalker talkLAURA)
					(Say 0 74 20)
				else
					(NotClose)
				)
			)
			((Said 'examine<(behind,below)/mirror')
				(Print 74 21)
			)
			((Said 'examine/mirror')
				(Print 74 22)
			)
			((Said 'get/mirror')
				(Print 74 23)
			)
			(
				(Said
					'open,(examine<in)/vanity,drawer,(nightstand<dressing)'
				)
				(if (== local2 2)
					(Print 74 24)
				else
					(event claimed: FALSE)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/vanity,(nightstand<dressing)')
				)
				(if (== local2 2)
					(Print 74 25)
					(event claimed: TRUE)
				else
					(event claimed: FALSE)
				)
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 157
		x 245
		view 174
		loop 2
		cel 8
		priority 11
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
		y 157
		x 101
		view 174
		loop 2
		cel 5
		priority 11
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 157
		x 140
		view 174
		loop 2
		cel 7
		priority 11
	)
	
	(method (handleEvent event)
		(if
			(and
				(>= currentAct 2)
				(< currentAct 6)
				(or (MousedOn self event shiftDown) (Said 'examine/nightstand'))
			)
			(if (== currentAct 5)
				(if local4
					(Print 74 26)
				else
					(Print 74 27)
				)
			else
				(Print 74 28)
			)
			(event claimed: TRUE)
		)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance glasses of RPicView
	(properties
		y 141
		x 142
		view 174
		loop 2
		cel 4
		priority 14
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/glass')
				(Print 74 29)
			)
			((Said 'examine<in/glass')
				(Print 74 30)
			)
			((or (Said 'examine/glass') (MousedOn self event shiftDown))
				(event claimed: TRUE)
				(Print 74 28)
			)
		)
	)
)

(instance decanter of RPicView
	(properties
		y 141
		x 130
		view 174
		loop 2
		cel 9
		priority 14
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			(
				(or
					(Said 'examine<use<monocle/decanter')
					(Said 'examine,(examine<at)/decanter/monocle<with')
					(Said 'examine/fingerprint')
				)
				(if (ego has: iMonocle)
					(if (< (ego distanceTo: table2) 20)
						(if (< currentAct 5)
							(Print 74 31 #icon 635 0 0)
						else
							(Print 74 32 #icon 635 0 2)
						)
						(Bset 11)
						(Bset 30)
					else
						(NotClose)
					)
				else
					(DontHave)
				)
			)
			(
				(or
					(Said 'drink/[<alcohol]')
					(Said 'drink,pour,get/decanter,alcohol')
					(Said 'open,get/decanter,alcohol')
				)
				(if (and local4 (== currentAct 5))
					(Print 74 33)
				else
					(Print 74 29)
				)
			)
			((Said 'examine<in/decanter,alcohol')
				(if (>= currentAct 5)
					(Print 74 34)
				else
					(Print 74 35)
				)
			)
			(
				(or
					(Said 'examine/decanter,alcohol')
					(MousedOn self event shiftDown)
				)
				(Bset 30)
				(if (>= currentAct 5)
					(Print 74 34)
				else
					(Print 74 36)
				)
				(event claimed: TRUE)
			)
		)
	)
)

(instance photo of RPicView
	(properties
		y 40
		x 138
		view 174
		loop 2
		cel 6
		priority 4
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {picture})
		)
	)
)

(instance phono of RPicView
	(properties
		y 62
		x 191
		view 174
		loop 2
		cel 11
		priority 4
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'cease,(rotate<off)/record,gramophone')
				(if (< (ego distanceTo: phono) 20)
					(if (and local4 (== currentAct 5))
						(if (record cycler?)
							(record setCycle: 0)
							(gDoor_2 stop:)
							(Print 74 37)
						else
							(Print 74 38)
						)
					else
						(Print 74 39)
					)
				else
					(NotClose)
				)
			)
			(
				(or
					(Said 'wind,play,(rotate<on)/gramophone,music,record,(player<record)')
					(Said 'get/music,record,(player<record)')
				)
				(if (and local4 (== currentAct 5))
					(Print 74 40)
				else
					(Print 74 39)
				)
			)
			((Said 'examine,find/record')
				(cond 
					((ego has: iBrokenRecord)
						(event claimed: FALSE)
					)
					((and local4 (== currentAct 5) (record cycler?))
						(Print 74 41)
					)
					((record cycler?)
						(Print 74 42)
					)
					(else
						(Print 74 43)
					)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/gramophone,armoire,(player<record)')
				)
				(event claimed: TRUE)
				(cond 
					((and local4 (== currentAct 5) (record cycler?))
						(Print 74 41)
					)
					((>= currentAct 5)
						(Print 74 44)
					)
					(else
						(Print 74 45)
					)
				)
			)
		)
	)
)

(instance record of Prop
	(properties
		y 53
		x 193
		view 174
		loop 7
		cel 5
		priority 4
		signal fixPriOn
	)
)

(instance flowers of Prop
	(properties
		y 143
		x 141
		view 174
		loop 2
		cel 10
		priority 14
		signal (| ignrAct fixPriOn)
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/blossom')
				(Print 74 46)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/blossom'))
				(event claimed: TRUE)
				(Print 74 47)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 93
		x 80
		view 174
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'change,(attach<on),wear/cloth')
				(Print 74 48)
			)
			((Said 'get,get,move/cloth')
				(Print 74 49)
			)
			((Said '(examine<(below,through)),search/dirt,cloth')
				(if local3
					(Print 74 50)
				else
					(NotClose)
				)
			)
			((Said 'examine/dirt,cloth,pile')
				(cond 
					(local3
						(Print 74 51)
					)
					(local4
						(Print 74 8)
					)
					(else
						(event claimed: FALSE)
					)
				)
			)
			((and local3 (Said 'drag,close,open/curtain'))
				(Print 74 52)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(DoLook {lamp})
			)
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 92
		x 68
		view 174
		loop 1
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/lamp')
				(Print 74 53)
			)
			((MousedOn self event shiftDown)
				(event claimed: TRUE)
				(DoLook {lamp})
			)
		)
	)
)

(instance door of Prop
	(properties
		y 104
		x 48
		view 174
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open/door')
				(cond 
					((ego inRect: 21 95 47 110)
						(cond 
							(global117
								(if (& global117 $8000)
									(AlreadyOpen)
								else
									(if (< (ego y?) (door y?))
										(ego posn: 33 89)
									)
									(self setScript: myDoor)
								)
							)
							((== local2 1)
								(Print 74 54)
							)
							(else
								(Print 74 55)
							)
						)
					)
					((== local2 2)
						(event claimed: FALSE)
					)
					(else (NotClose))
				)
			)
			((Said 'close/door')
				(cond 
					((ego inRect: 21 95 47 115)
						(if (not (& global117 $8000))
							(AlreadyClosed)
						else
							(self setScript: myDoor)
						)
					)
					((== local2 2)
						(event claimed: FALSE)
					)
					(else (NotClose))
				)
			)
			(
			(or (Said 'use,unbar/key,door') (Said 'open/door/key'))
				(cond 
					(global117
						(Print 74 56)
					)
					((ego inRect: 21 95 47 110)
						(cond 
							((== local2 3)
								(= global117 1)
								(Print 74 57)
							)
							((ego has: iSkeletonKey)
								(= global117 1)
								(Print 74 58)
							)
							(else
								(Print 74 59)
							)
						)
					)
					(else
						(NotClose)
					)
				)
			)
			((Said 'bang[/door]')
				(if (ego inRect: 21 95 47 110)
					(if (not (& global117 $8000))
						(self setScript: knockDoor)
					else
						(Print 74 60)
					)
				else
					(NotClose)
				)
			)
			((Said 'find,enter,(go[<in])/attic')
				(if (== local2 1)
					(Print 74 61)
				else
					(event claimed: FALSE)
				)
			)
			((Said 'examine/keyhole')
				(if (== local2 1)
					(Print 74 62)
				else
					(event claimed: FALSE)
				)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/door[<attic]')
				)
				(event claimed: TRUE)
				(if (== local2 2)
					(Print 74 63)
				else
					(Print 74 64)
				)
			)
		)
	)
)

(instance Tswing of Prop
	(properties
		y 94
		x 233
		view 174
		loop 4
	)
	
	(method (handleEvent event)
		(if
			(and
				(== local2 2)
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/door[<swinging]')
				)
			)
			(Print 74 65)
			(event claimed: TRUE)
		)
	)
)

(instance Bswing of Prop
	(properties
		y 105
		x 245
		view 174
		loop 5
	)
	
	(method (handleEvent event)
		(if
			(and
				(== local2 2)
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/door[<swinging]')
				)
			)
			(Print 74 65)
			(event claimed: TRUE)
		)
	)
)

(instance FifiButt of Prop
	(properties
		y 153
		x 252
		view 478
		loop 4
	)
)

(instance Fifi of Actor
	
	(method (handleEvent event)
		(if (not local7)
			(= theTalker talkFIFI)
			(cond 
				((Said 'hear/fifi')
					(Print 74 66)
				)
				((Said 'converse/fifi')
					(switch talkCount
						(0 (Say 1 74 67))
						(1 (Say 1 74 68))
						(2 (Say 1 74 69))
						(3 (Say 1 74 70))
						(4 (Say 1 74 71))
						(else  (Print 74 72))
					)
					(++ talkCount)
				)
				((or (MousedOn self event shiftDown) (Said 'examine/fifi'))
					(event claimed: TRUE)
					(if (not (& global207 $0010))
						(= global207 (| global207 $0010))						
;;;						(|= global207 $0010)
						(Say 0 74 73)
					else
						(Print 74 74)
					)
				)
			)
		)
	)
)

(instance mySound of Sound)

(instance myMusic of Sound)

(instance myDoor of Script
	
	(method (doit)
		(if (== (mySound prevSignal?) 11)
			(DoSound ChangeVolume 0)
			(= cycles 1)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (ego y?) (door y?))
					(ego setMotion: MoveTo 33 89 self)
				else
					(ego setMotion: MoveTo 33 106 self)
				)
			)
			(1
				(if (<= (ego y?) (door y?))
					(ego loop: 2)
				else
					(ego loop: 3)
				)
				(mySound prevSignal: 0)
				(HandsOff)
				(if (not (& global117 $8000))
					(mySound number: 43 loop: 1 priority: 10 play:)
					(DoSound ChangeVolume saveVolume)
					(door loop: 6 setCycle: EndLoop)
					(ego illegalBits: cWHITE)
;;;					(|= global117 $8000)
					(= global117 (| global117 $8000))
				else
					(mySound number: 44 loop: 1 priority: 10 play:)
					(DoSound ChangeVolume saveVolume)
					(door loop: 6 setCycle: BegLoop)
;;;					(ego illegalBits: (| cWHITE cCYAN))
					(ego illegalBits: -32760)
;;;					(&= global117 $7fff)
					(= global117 (& global117 $7fff))
				)
			)
			(2
				(if (not (& global117 $8000))
					(door loop: (if (< (ego y?) 104) 3 else 6) stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)
