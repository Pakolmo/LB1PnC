;;; Sierra Script 1.0 - (do not remove this comment)
(script# 950)
(include game.sh)
(include menu.sh)
(include sci.sh)
(use Main)
(use Game)
(use Gauge)
(use System)
(use Actor)
(use Intrface)
(use user)
(use Motion)
(use Invent)
(use Sound)
(use Save)

(public
	PnCMenu 0
	ShowMenu 1
)

(local
	[txtstring 50]
	yIconStep =  4
	howLong =  50
	gShowMenu
	doMenuTimer
	menuTime
	pickedLoad ;added for load save merge
	newEvent
	tempCur
)

(procedure (ShowMenu)
	(walkIcon show:)
	(lookIcon show:)
	(handIcon show:)
	(talkIcon show:)
	(smellIcon show:)
	(invIcon show:)
	(blockIcon show:)
	(selectedItem show:)
	(levelsIcon show:)
	(saveIcon show:)
	(quitIcon show:)
)

(instance PnCMenu of Region
	(properties)
	
	(method (init)
		(super init:)
		(self setScript: PnCMenuScript)
		(switch gLayout
			(0
				(= yPosition 22)
				(= yPositionInventory 18)
				(walkIcon setPri: 15 y: yPosition init:)
				(lookIcon setPri: 15 y: yPosition init:)
				(handIcon setPri: 15 y: yPosition init:)
				(talkIcon setPri: 15 y: yPosition init:)

				;(background setPri: 15 y: yPosition init:)
				;;(invIcon setPri: 15 y: yPosition init:)
				;;(blockIcon setPri: 14 y: yPositionInventory init:) ;was setPri: 14
				(levelsIcon setPri: 15 y: yPosition init:)
				;(restartIcon setPri: 15 y: yPosition init:)
				;(loadIcon setPri: 15 y: yPosition init:)
				(saveIcon setPri: 15 y: yPosition init:)
				(quitIcon setPri: 15 y: yPosition init:)
				(if (!= itemIcon 600) ;nothing
					(selectedItem setPri: 15 y: yPositionInventory cel: itemIcon init:)
				else
					(selectedItem setPri: 15 y: yPositionInventory cel: 0 init:)
				)
			)
			(2
				(= yPosition 189)
				(= yPositionInventory 18)
				(walkIcon setPri: 15 y: yPosition init:)
				(lookIcon setPri: 15 y: yPosition init:)
				(handIcon setPri: 15 y: yPosition init:)
				(talkIcon setPri: 15 y: yPosition init:)				

				;(background setPri: 15 y: yPosition init:)
				(invIcon setPri: 15 y: yPosition init:)
				(blockIcon setPri: 14 y: yPositionInventory init:) ;was setPri: 14
				(levelsIcon setPri: 15 y: yPosition init:)
				;(restartIcon setPri: 15 y: yPosition init:)
				;(loadIcon setPri: 15 y: yPosition init:)
				(saveIcon setPri: 15 y: yPosition init:)
				(quitIcon setPri: 15 y: yPosition init:)
				(if (!= itemIcon 600) ;nothing
					(selectedItem setPri: 15 y: yPositionInventory cel: itemIcon init:)
				else
					(selectedItem setPri: 15 y: yPositionInventory cel: 0 init:)
				)
			)
			(else 
				(walkIcon setPri: 15 y: yPosition init:)
				(lookIcon setPri: 15 y: yPosition init:)
				(handIcon setPri: 15 y: yPosition init:)
				(talkIcon setPri: 15 y: yPosition init:)
				(smellIcon setPri: 15 y: yPosition init:)
				;(background setPri: 15 y: yPosition init:)
				(invIcon setPri: 15 y: yPosition init:)
 				(blockIcon setPri: 14 y: yPosition init:) ;was setPri: 14
				(levelsIcon setPri: 15 y: yPosition init:)
				;(restartIcon setPri: 15 y: yPosition init:)
				;(loadIcon setPri: 15 y: yPosition init:)
				(saveIcon setPri: 15 y: yPosition init:)
				(quitIcon setPri: 15 y: yPosition init:)
				(if (!= itemIcon 600) ;nothing
;;;					(blockIcon
;;;						setPri: 14
;;;						y: yPosition
;;;						cel: itemIcon
;;;						init:
;;;						setScript: showButtons
;;;					)
					(selectedItem
						setPri: 15
						y: yPositionInventory
						cel: itemIcon
						init:
						setScript: showButtons
					)
				else
					(selectedItem
						setPri: 15
						y: yPosition
						cel: 0
						init:
						setScript: showButtons
					)
				)
			)
		)
	)
)

(instance PnCMenuScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== gLayout 1)
			(switch movingButtons
				(0
					(cond 
						(
							(or
								(== yPosition 0)
								(== yPosition 400)
							)
							(if (== gShowMenu 1)
								(= yPosition 0)
								(= movingButtons 1)
							)
						)
						((>= yPosition 20)
							(cond 
								((== gShowMenu 0)
									(= movingButtons 2)
								)
								((>= menuTime howLong)
									(= doMenuTimer 0)
									(= gShowMenu 0)
									(= menuTime 0)
								)
								(else
									(++ menuTime)
								)
							)
						)
					)
				)
				(1
					(if (>= yPosition 25) (= movingButtons 0))
				)
			)
		)
		(selectedItem loop: 2 cel: itemIcon)
		(blockIcon view: 950 loop: 2 cel: 0) ;inv item background cel
		(switch theCursor
			(999
				(walkIcon loop: 1)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
				(invIcon loop: 0)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
			(998
				(walkIcon loop: 0)
				(lookIcon loop: 1)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
				(invIcon loop: 0)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
			(995
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 1)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
				(invIcon loop: 0)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
			(996
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 1)
				(smellIcon loop: 0)
				(invIcon loop: 0)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
			(994
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 1)
				(invIcon loop: 0)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
			(itemIcon
				(walkIcon loop: 0)
				(lookIcon loop: 0) ;init:)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
				(invIcon loop: 1)
				(levelsIcon loop: 0)
				(saveIcon loop: 0)
				(quitIcon loop: 0)
			)
		)
		(if (!= itemIcon 601)
			(selectedItem view: itemIcon) ;inventory views == inventory item number
		else
			(selectedItem view: 601) ;fix crossbar	
		)
	)
	
	(method (handleEvent event &tmp haveMouse sndPause)
		(super handleEvent: event)
		(= haveMouse (HaveMouse)) ;fix rightclick crash in scummvm
		(if (== (event type?) evMOUSEBUTTON)
			(if modelessDialog
				(modelessDialog dispose:)
			)
			;(blockIcon setCel: itemIcon) ; added to keep menu item up to date
			(if (& (event modifiers?) emRIGHT_BUTTON)
				(if (== programControl 1)
					(event claimed: 1)
				else
					(event claimed: 1)
					(= menuTime 0)
					(switch theCursor
						(itemIcon
							(theGame setCursor: 999 haveMouse)
						)
						(999 ;walk
								(theGame setCursor: 998 haveMouse)
							
						)
						(996
							(theGame setCursor: 994 haveMouse)
						)
						(994 ;smell

								(if
									(or 
										(== itemIcon 997)
										(== itemIcon 993)
									)
									(theGame setCursor: 999 haveMouse)
								else
									(theGame setCursor: itemIcon haveMouse)
									(= theCursor itemIcon)
								)
							
						)
						(998 ;eye
							(theGame setCursor: 995 haveMouse)
						)
						(995 ;hand
							(theGame setCursor: 996 haveMouse)
						)

						(991 ;Salir/exit
								(theGame setCursor: 998 haveMouse)
						)
;;;						(990
;;;
;;;								(if
;;;									(or 
;;;										(== itemIcon 900)
;;;										(== itemIcon 993)
;;;									)
;;;									(theGame setCursor: 999 haveMouse)
;;;								else
;;;									(theGame setCursor: itemIcon haveMouse)
;;;									(= theCursor itemIcon)
;;;								)
;;;							
;;;						)
;;;						(110 ;Kit
;;;							
;;;						)
						(else
							(theGame setCursor: 999 haveMouse)
						)
					)
				)
			)
			(if (not (& (event modifiers?) emRIGHT_BUTTON))
				(cond 
					((== programControl 1) (event claimed: 1))
					((< (event y?) 1)
						(event type: 1 claimed: 1)
						(switch movingButtons
							(0
								(if (== gLayout 1)
									(if (== gShowMenu 1)
										(= gShowMenu 0)
									else
										(= gShowMenu 1)
									)
								)
							)
							(1 (= movingButtons 2) (= gShowMenu 0))
							(2 (= movingButtons 1) (= gShowMenu 1))
						)
					)
					(
						(and
							(> (event x?) (walkIcon nsLeft?))
							(< (event x?) (walkIcon nsRight?))
							(> (event y?) (walkIcon nsTop?))
							(< (event y?) (walkIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(theGame setCursor: 999 haveMouse)
					)
					(
						(and
							(> (event x?) (talkIcon nsLeft?))
							(< (event x?) (talkIcon nsRight?))
							(> (event y?) (talkIcon nsTop?))
							(< (event y?) (talkIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(theGame setCursor: 996 haveMouse)
					)
					(
						(and
							(> (event x?) (lookIcon nsLeft?))
							(< (event x?) (lookIcon nsRight?))
							(> (event y?) (lookIcon nsTop?))
							(< (event y?) (lookIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(theGame setCursor: 998 haveMouse)
					)
					(
						(and
							(> (event x?) (handIcon nsLeft?))
							(< (event x?) (handIcon nsRight?))
							(> (event y?) (handIcon nsTop?))
							(< (event y?) (handIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(theGame setCursor: 995 haveMouse)
					)
					((ClickedOnObj smellIcon (event x?) (event y?))
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(theGame setCursor: 994 haveMouse)
					)
					
;;;					(
;;;						(and
;;;							(> (event x?) (background nsLeft?))
;;;							(< (event x?) (background nsRight?))
;;;							(> (event y?) (background nsTop?))
;;;							(< (event y?) (background nsBottom?))
;;;						)
;;;						(event claimed: 1)
;;;						(if (and (== gLayout 1) (!= movingButtons 2))
;;;							(= movingButtons 2)
;;;							(= gShowMenu 0)
;;;						)
;;;						(= menuTime 0)
;;;						
;;;					)
					(
						(and
							(> (event x?) (invIcon nsLeft?))
							(< (event x?) (invIcon nsRight?))
							(> (event y?) (invIcon nsTop?))
							(< (event y?) (invIcon nsBottom?))
						)
						(event claimed: 1)
;;;						(if (and (== gLayout 1) (!= movingButtons 2))
;;;							(= movingButtons 2)
;;;							(= gShowMenu 0)
;;;						)
;;;						(= menuTime 0)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						
						(= movingButtons 2)
						(= gShowMenu 0)
						(= menuTime 51)
						(= yPosition 0)
						(invIcon setScript: dotheinv)
					)
					((ClickedOnObj selectedItem (event x?) (event y?))
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(if (!= itemIcon 900)
							(theGame setCursor: itemIcon haveMouse)
							(= theCursor itemIcon)
						else
;;;							(Print {You must first selected an item.}) ;English
							(Print {Primero debes elegir un objeto.}) ;Spanish
						)
					)
					(
						(and
							(> (event x?) (levelsIcon nsLeft?))
							(< (event x?) (levelsIcon nsRight?))
							(> (event y?) (levelsIcon nsTop?))
							(< (event y?) (levelsIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(invIcon setScript: dothelevels)
					)
;;;					(
;;;						(and
;;;							(> (event x?) (restartIcon nsLeft?))
;;;							(< (event x?) (restartIcon nsRight?))
;;;							(> (event y?) (restartIcon nsTop?))
;;;							(< (event y?) (restartIcon nsBottom?))
;;;						)
;;;						(event claimed: 1)
;;;						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
;;;						(= menuTime 0)
;;;						(restartIcon setScript: dotherestart)
;;;					)
;;;					(
;;;						(and
;;;							(> (event x?) (loadIcon nsLeft?))
;;;							(< (event x?) (loadIcon nsRight?))
;;;							(> (event y?) (loadIcon nsTop?))
;;;							(< (event y?) (loadIcon nsBottom?))
;;;						)
;;;						(event claimed: 1)
;;;						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
;;;						(= menuTime 0)
;;;						(loadIcon setScript: dotheload)
;;;					)
					(
						(and
							(> (event x?) (saveIcon nsLeft?))
							(< (event x?) (saveIcon nsRight?))
							(> (event y?) (saveIcon nsTop?))
							(< (event y?) (saveIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(saveIcon setScript: dothesave)
					)
					(
						(and
							(> (event x?) (quitIcon nsLeft?))
							(< (event x?) (quitIcon nsRight?))
							(> (event y?) (quitIcon nsTop?))
							(< (event y?) (quitIcon nsBottom?))
						)
						(event claimed: 1)
						(if (== movingButtons 2) (= movingButtons 1) (= gShowMenu 1))
						(= menuTime 0)
						(quitIcon setScript: dothequit)
					)
					((MousedOn ego event 0) ; left click on ego
						(switch theCursor ;what cursor?
							(999 ;walk
								(event type: 1 claimed: 0) ;Don't claim event, let walk script take it
							)
							(997 ;sierra wait
								(event type: 1 claimed: 0) ;Don't claim event, let walk script take it
							)
							(998 ;look
								(event type: 1 claimed: 1) ;claim event so other scripts don't use it

							)
							(996 ;talk
								(event type: 1 claimed: 1)
;;;								(switch (Random 0 2)
;;;									(0 (Print 950 13))
;;;									(1 (Print 950 14))
;;;									(2 (Print 950 15))
								
;;;								)
							)
							(995 ;hand
													(event type: 1 claimed: 1)	
;;;													(= sndPause (Sound pause: 1)) ;NO inventory on Laura.
;;;													(Inv showSelf: 888)
;;;													(Sound pause: sndPause)
;;;													(DoUseItem useInvItem event)
								
								
								
								
							)
							(994
								(event type: 1 claimed: 1)
								
							)			
						)
										
					)
				
						
											;FIFI override
					(
						(and 
							(== (event claimed?) FALSE)
							(== curRoomNum 47)
						)
						;ignore so clicks pass to jet script 77
					)
				
					;Room defaults if nothing else is clicked on.
					(else 
						(switch theCursor
							(999 ;walk
								(if isHandsOff
									(event claimed: TRUE)
								else
									(event type: 1 claimed: 0)
								)
							)
							(998 ;look
								(event type: 1 claimed: 1)
								(DoVerb {look room})	
							)
							(996 ;talk 
								(event type: 1 claimed: 1)
;;;								(Print {(There is no response.)} #at -1 144) ;"(There is no response.)"
								(Print {(No hay respuesta.)} #at -1 144) ;"(There is no response.)"
							)
							(995 ;hand
								(event type: 1 claimed: 1)
;;;								(Print {(What do you want to take?.)}) ;"What do you want to take?"
								(Print {(&Qu+ quieres coger?)}) ;"What do you want to take?"
							)
							(994 ;smell
								(event type: 1 claimed: 1)
;;;								(Print {(What do you want to take?.)}) ;"What do you want to take?"
								(Print {(No oigo nada.)}) ;"What do you want to take?"
							)							
							(997 ;wait sierra
								(event type: 1 claimed: 0)
							)
							(else ;inventory item
								(event type: 1 claimed: 1)
;;;								(Print {no need to use that here.}) ;"no need to use that here"
								(Print {No hay ninguna necesidad de usar esto ah-.}) ;"no need to use that here"
							)
						
						)
					)
				)
			)
		)
	)
)

(instance dothequit of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(= gPreviousCursor theCursor)
				(theGame setCursor: 993 (HaveMouse)) ;switch to select
				(quitIcon loop: 1)
				(= cycles 3)
			)
			(1
				(if
					(Print
						950 26
;;;						#title {Quit} ;English
						#title {Salir} ;Spanish
						#font 1
;;;						#button { Quit_} 1 ;English
;;;						#button { Oops } 0 ;English
						#button { Salir_} 1 ;Spanish
						#button { Ups } 0 ;Spanish
					)
					(= quit 1)
				else
					(theGame setCursor: gPreviousCursor (HaveMouse))
					(quitIcon loop: 0)
				)
			)
		)
	)
)

(instance dothesave of Script
	(properties)
	
	(method (changeState newState &tmp loadOrSave)
		(= state newState)
		(switch state
			(0
				(= gPreviousCursor theCursor)
				(theGame setCursor: 993 (HaveMouse)) ;switch to select
				(saveIcon loop: 1) ;change to icon "clicked"
				(= cycles 3) ;wait 3 cycles, then goto next state.
			)
			(1
				(= loadOrSave 
					(Print
						950 30 
;;;						#button {\n__SAVE__\n_} 1 ;#button (string) (pickedLoad==1) ;ENGLISH
;;;						#button {\n__LOAD__\n_} 2 ;(pickedLoad=0) ;ENGLISH
						#button {\n__SALVAR__\n_} 1 ;#button (string) (pickedLoad==1) ;SPANISH
						#button {\n__CARGAR__\n_} 2 ;(pickedLoad=0) ;SPANISH
					)
				)
				(switch loadOrSave
					(0
						(theGame setCursor: gPreviousCursor (HaveMouse))
						(= cycles 1)
					)	
					(1
							(= saveVolume (theGame setVolume: pncVolume))
							(theGame setVolume: pncVolume)
;;;							(Bset 0) ;use un-use flag 0 for save hack						
						(Bset fPnCVolumeFlag)
						(Bset fPnCSaveFlag)
						(= cycles 1)
					)
					(2
						(if saveDisabled
							(Print 997 2) ; "You cannot restore a game right now."
						else
							(theGame restore:)
							(theGame setVolume: saveVolume)
						)
						(= cycles 1)
					)
				)
			)
			(2
				(theGame setCursor: gPreviousCursor (HaveMouse))
				(saveIcon loop: 0)
			)
		)
	)
)

;;;(instance dotherestart of Script
;;;	(properties)
;;;	
;;;	(method (changeState newState)
;;;		(= state newState)
;;;		(switch state
;;;			(0
;;;				(restartIcon loop: 1)
;;;				(= cycles 3)
;;;			)
;;;			(1
;;;				(if
;;;					(Print MENU 3
;;;;;;	 					#title {Restart} ;ENGLISH
;;;	 					#title {Reiniciar} ;SPANISH
;;;						#font bigFont
;;;;;;						#button {Restart} 1 ;ENGLISH
;;;;;;						#button { Oops_} 0 ;ENGLISH
;;;						#button {Reiniciar} 1 ;SPANISH
;;;						#button { Ups_} 0 ;Spanish			
;;;					)
;;;					(theGame restart:)
;;;				else
;;;					(restartIcon loop: 0)
;;;					(= newState 0)
;;;				)
;;;			)
;;;		)
;;;	)
;;;)

(instance dothelevels of Script
	(properties)
	
	(method (changeState newState &tmp [str 220] newTextColor newBackColor)
		(= state newState)
		(switch state
			(0
				(= gPreviousCursor theCursor)
				(theGame setCursor: 993 (HaveMouse)) ;switch to select
				(levelsIcon loop: 1)
				(= cycles 3)
			)
			(1
				(= sGauge2
					(Print
						950 33 ;"configuration:" 
;;;						#button {\n_SPEED_\n_} 1 ;#button (string) (pickedLoad==1) ;ENGLISH
;;;						#button {\n_VOLUME_\n_} 0 ;(pickedLoad=0) ;ENGLISH
						#button {\n_VELOCIDAD_\n_} 1 ;#button (string) (pickedLoad==1) ;SPANISH
						#button {\n_VOLUMEN_\n_} 2 ;(pickedLoad=0) ;SPANISH
;;;						#button {\n_INSULT_\n_} 3 ;ENGLISH
;;;						#button {\n_AUTOSAVE_\n_} 4 ;ENGLISH
;;;						#button {\n_ABOUT_\n_} 5 ;ENGLISH
;;;						#button {\n_TEXT COLOR_\n_} 6 ;ENGLISH
						;#button {\n_INSULTO_\n_} 3 ;SPANISH
						;#button {\n_AUTOSALVAR_\n_} 4 ;SPANISH
						;#button {\n__CREDITOS_\n_} 5 ;SPANISH
						;#button {\n_COLORES_\n_} 6 ;SPANISH
					)
				)
				(switch sGauge2
					(0
						(theGame setCursor: gPreviousCursor (HaveMouse))
						(= cycles 1)
					)
					(1
						(= sGauge 1)
						(= state 9)	
					)
					(2
						(= vGauge 2)
						(= state 19)
					)
;;;					(3
;;;						(= state 29)
;;;					)
;;;					(4
;;;						(= state 39)
;;;					)
;;;					(5
;;;						(= state 49)
;;;					)
;;;					(6
;;;						(= state 59)
;;;					)
				)
				(= cycles 1)
			)
			(10
				(if (HaveMem GaugeSize)
					(= pncSpeed
						((Gauge new:)
							description:
								(Format @str 950 34)
;;;							text: {Animation Speed} ;ENGLISH
							text: {Velocidad del Juego} ;SPANISH
							normal: 10
;;;							higher: {Faster} ;ENGLISH
;;;							lower: {Slower} ;ENGLISH
							higher: {Subir} ;SPANISH
							lower: {Bajar} ;SPANISH
							doit: (- 16 speed)
						)
					)
					(theGame setSpeed: (- 16 pncSpeed))
					(DisposeScript GAUGE)
				)
				(= state 99)
				(= cycles 1)
			)
			(20
				
				(if (HaveMem GaugeSize)
					(= pncVolume
						((Gauge new:)
							description: (Format @str 950 35)
;;;							text: {Sound Volume} ;ENGLISH
							text: {Volumen} ;SPANISH
							normal: 11
;;;							higher: {Louder} ;ENGLISH
;;;							lower: {Softer} ;ENGLISH
							higher: {Subir} ;SPANISH
							lower: {Bajar} ;SPANISH
							doit: (DoSound 8 pncVolume) 
							
						)
					)
					(DoSound 8 pncVolume)
					(Bset fPnCVolumeFlag)
					(DisposeScript GAUGE)
					(= state 99)
					(= cycles 1)
				)	
			)


			(50 ;About/sobre
				(Print MENU 14 ;MENU 0
					#font smallFont
					#mode teJustCenter
;;;					#title {An Al Lowe Production} ;english
					#title {Una Producci>n de Al Lowe} ;spanish
					#icon 51 0 0
				)
				(Print
					(Format @str MENU 15 version) ;MENU 1 version
					#font smallFont
					#mode teJustCenter
					#title {The Cast of Thousands} ;english
					#title {El elenco de los miles} ;spanish
					#at -1 30
					#width 234
				)
			)
			(100
				(theGame setCursor: gPreviousCursor (HaveMouse))
				(levelsIcon loop: 0)
			)
		)
	)
)

(instance dotheinv of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(if (== canTab 1)
					(= gPreviousCursor theCursor)
					(invIcon loop: 1)
					(= cycles 3)
				else
					(Print 950 9)
				)
			)
			(1 (= doInventory 1)
				(if (HaveMem 1024) ;InvSize)
					(inventory showSelf: ego)
				)
			)
		)
	)
)
(instance walkIcon of Prop
	(properties
		y 6
		x 15 ;14
		view 950
		loop 0
		cel 0
	)
)

(instance lookIcon of Prop
	(properties
		y 6
		x 43
		view 950
		cel 1
		loop 0
	)
)

(instance handIcon of Prop
		(properties
		y 6
		x 70	
		view 950
		cel 2
		loop 0
	)
)

(instance talkIcon of Prop
	(properties
		y 6
		x 97
		view 950
		cel 3
		loop 0
	)
)


(instance smellIcon of Prop
	(properties
		y 6 ;189
		x 124 ;move the rest of the icons down (x + 30)
		view 950
		cel 10
		loop 0
	)
)

;;;(instance background of Prop
;;;	(properties
;;;		y 6
;;;		x 169 ;197 ;move the rest of the icons down (x + 30)
;;;		view 950
;;;		cel 0
;;;		loop 7
;;;
;;;	)
;;;)

(instance invIcon of Prop
	(properties
		y 6
		x 215 ;248 ;138 ;127 ;move the rest of the icons down (x + 28)
		view 950
		cel 5
		loop 0
	)
)

(instance blockIcon of Prop
	(properties
		y 6
		x 169 ;171 ;;as selectedicon
		view 950
		loop 2
		cel 0
	)
)

(instance levelsIcon of Prop
	(properties
		y 6
		x 243 ;220
		view 950
		cel 6
		loop 0
	)
)

;combine with save?
;;;(instance restartIcon of Prop
;;;	(properties
;;;		y 6
;;;		x 248
;;;		view 950
;;;		cel 7
;;;		loop 0
;;;	)
;;;)

;;;(instance loadIcon of Prop ;combine load/save icons to make room for smell
;;;	(properties
;;;		y 189
;;;		x 250
;;;		view 950
;;;		cel 7
;;;		loop 0
;;;	)
;;;)

(instance saveIcon of Prop
	(properties
		y 6
		x 272
		view 950
		cel 8
		loop 0
	)
)

(instance quitIcon of Prop
	(properties
		y 6
		x 303
		view 950
		cel 9
		loop 0
	)
)

;;;(instance restartIcon of Prop
;;;	(properties
;;;		y 6 ;189
;;;		x 248
;;;		view 950
;;;		cel 7
;;;		loop 0
;;;	)
;;;)

(instance selectedItem of Prop
	(properties
		y 6
		x 169 ;as bloxk icon;
		view 950 ;950
		loop 3; ;3
		cel 0
	)
)

(instance showButtons of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(switch movingButtons
			(0)
			(1
				(if (< yPosition 25)
					;(= yPosition (+ yPosition yIconStep))
					(= yPosition 25)
					(= menuTime 0)
				else
					(= movingButtons 0)
					(= doMenuTimer 1)
				)
			)
			(2
				(if (and (> yPosition 0) (< yPosition 400))
					(= yPosition (- yPosition yIconStep))
				else
					(= movingButtons 0)
					(= yPosition 400)
				)
			)
		)
		(walkIcon y: yPosition)
		(lookIcon y: yPosition)
		(handIcon y: yPosition)
		(talkIcon y: yPosition)
		(smellIcon y: yPosition)
		;(background y: yPosition)
		(invIcon y: yPosition)
		(blockIcon y: yPosition)
		(levelsIcon y: yPosition)
		;(restartIcon y: yPosition)
		;(loadIcon y: yPosition)
		(saveIcon y: yPosition)
		(quitIcon y: yPosition)
		(if (!= itemIcon 950)
			(selectedItem y: yPosition)
		else
			(selectedItem y: yPosition)
		)
	)
)