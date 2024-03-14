;;;;;; Sierra Script 1.0 - (do not remove this comment)
;;;(script# MENU)
;;;(include game.sh) (include menu.sh)
;;;(use Main)
;;;(use Intrface)
;;;(use Sound)
;;;(use Invent)
;;;(use User)
;;;
;;;(public
;;;	DebugTP 2
;;;)
;;;
;;;(procedure (DebugTP theRoom &tmp n)
;;;	(= n (GetNumber {Teleport to room:}))
;;;	(theRoom newRoom: (if (< n 1) 1 else n))
;;;)
;;;
;;;(procedure (ShowHelp)
;;;	(Print MENU 7
;;;		#font 4
;;;		#width 275
;;;	)
;;;)
;;;
;;;(class TheMenuBar of MenuBar
;;;	
;;;	(method (init)
;;;		(= menuBarInitialized TRUE)
;;;		(AddMenu { \01_}
;;;			{About Bequest:Help`#1}
;;;		)
;;;		(AddMenu { File_}
;;;			{Save`#5:Restore`#7:-!:Restart`#9:Quit`^q}
;;;		)
;;;		(AddMenu { Action_}
;;;			{Pause`^p:Inventory`^i:Retype`#3:Ask about...`^a:Tell about...`^t:Show...`^s:Give...`^g:Look at...`^l}
;;;		)
;;;		(AddMenu { Speed_}
;;;			{Faster`+:Normal`=:Slower`-}
;;;		)
;;;		(AddMenu { Sound_}
;;;			{Volume`^v:-!:Turn Off=1`#2}
;;;		)
;;;		(SetMenu soundI p_text
;;;			(if (DoSound SoundOn) {Turn Off}
;;;			else {Turn On}
;;;			)
;;;		)
;;;		(SetMenu helpI p_said 'help[/game]')
;;;		(SetMenu saveI p_said 'save[/game]')
;;;		(SetMenu restoreI p_said 'restore[/game]')
;;;		(SetMenu restartI p_said 'restart[/game]')
;;;		(SetMenu quitI p_said 'quit[/game]')
;;;		(SetMenu pauseI p_said 'pause[/game]')
;;;		(SetMenu invI p_said 'inventory')
;;;	)
;;;	
;;;	(method (handleEvent event &tmp evt i [temp2 3] oldPause [temp6 255])
;;;		(= savedCursor ARROW_CURSOR)
;;;		(theGame setCursor: ARROW_CURSOR TRUE)
;;;		(switch (= evt (super handleEvent: event))
;;;			(aboutI
;;;				(= oldPause (Sound pause: TRUE))
;;;				(Print MENU 0 #font smallFont #at 10 10 #width 290)
;;;				(Sound pause: oldPause)
;;;			)
;;;			(helpI
;;;				(= oldPause (Sound pause: TRUE))
;;;				(ShowHelp)
;;;				(Sound pause: oldPause)
;;;			)
;;;			(saveI
;;;				(if saveDisabled
;;;					(Print MENU 1)
;;;				else
;;;					(theGame save:)
;;;				)
;;;			)
;;;			(restoreI
;;;				(if saveDisabled
;;;					(Print MENU 2)
;;;				else
;;;					(theGame restore:)
;;;				)
;;;			)
;;;			(restartI
;;;				(= oldPause (Sound pause: TRUE))
;;;				(if
;;;					(Print MENU 3
;;;						#font SYSFONT
;;;						#button {__Restart__} 1
;;;						#button { Continue_} 0
;;;					)
;;;					(theGame restart:)
;;;				)
;;;				(Sound pause: oldPause)
;;;			)
;;;			(quitI
;;;				(= oldPause (Sound pause: TRUE))
;;;				(= quit
;;;					(Print MENU 4
;;;						#font SYSFONT
;;;						#button {____Quit____} 1
;;;						#button { Continue_} 0
;;;					)
;;;				)
;;;				(Sound pause: oldPause)
;;;			)
;;;			(pauseI
;;;				(= oldPause (Sound pause: 1))
;;;				(Print MENU 5
;;;					#font SYSFONT
;;;					#button {__Continue__} 0
;;;				)
;;;				(Sound pause: oldPause)
;;;			)
;;;			(invI
;;;				(if (not (HaveMem InvSize))
;;;					(Print MENU 6)
;;;				else
;;;					(= oldPause (Sound pause: TRUE))
;;;					(Inventory showSelf: ego)
;;;					(Sound pause: oldPause)
;;;				)
;;;			)
;;;			(repeatI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;			)
;;;			(askI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;				(StrCpy (User inputLineAddr?) {Ask about_})
;;;			)
;;;			(tellI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;				(StrCpy (User inputLineAddr?) {Tell about_})
;;;			)
;;;			(showI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;				(StrCpy (User inputLineAddr?) {Show_})
;;;			)
;;;			(giveI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;				(StrCpy (User inputLineAddr?) {Give_})
;;;			)
;;;			(lookI
;;;				(event claimed: FALSE type: keyDown message: (User echo?))
;;;				(StrCpy (User inputLineAddr?) {Look at_})
;;;			)
;;;			(fasterI
;;;				(if (> speed 1)
;;;					(theGame setSpeed: (-- speed))
;;;				)
;;;			)
;;;			(normalI
;;;				(theGame setSpeed: 6)
;;;			)
;;;			(slowerI
;;;				(theGame setSpeed: (++ speed))
;;;			)
;;;			(volumeI
;;;				(if
;;;					(and
;;;						(!= curRoomNum 74)
;;;						(!= curRoomNum 64)
;;;						(!=
;;;							(= i
;;;								(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound ChangeVolume)))
;;;							)
;;;							-1
;;;						)
;;;					)
;;;					(if (< (-- i) 0) (= i 0))
;;;					(if (> i 15) (= i 15))
;;;					(DoSound ChangeVolume i)
;;;				)
;;;			)
;;;			(soundI
;;;				(if (= i (DoSound SoundOn))
;;;					(SetMenu soundI p_text {Turn On})
;;;				else
;;;					(SetMenu soundI p_text {Turn Off})
;;;				)
;;;				(DoSound SoundOn (not i))
;;;			)
;;;			(else 
;;;				(if global392
;;;					(global392 doit: evt)
;;;				)
;;;			)
;;;		)
;;;	)
;;;)
;;;
;;; Sierra Script 1.0 - (do not remove this comment)
(script# MENU)
(include game.sh) (include menu.sh)
(use Main)
(use Intrface)
(use Gauge)
(use Sound)
(use User)

(public
	ToggleSound 1
)

(local
	oldPause
)
(procedure (ToggleSound &tmp i)
	(= i (DoSound SoundOn))
	(DoSound SoundOn (not i))
	(if i
		(SetMenu soundI p_text {Turn On}) ;English
;;;		(SetMenu soundI p_text {Encender}) ;Spanish
	else
		(SetMenu soundI p_text {Turn Off}) ;English
;;;		(SetMenu soundI p_text {Apagar}) ;Spanish
	)
)

(class TheMenuBar of MenuBar
	(properties
		state 0
		name "MenuBar"
	)
	
	(method (init)
		(AddMenu
			"The Colonel's Bequest -Point and Click- "
				"About Template`^a:"
		)
;;;		(if (== curRoomNum 44) ;ADD PnCMenu
;;;			(Print {TEST})
;;;			(curRoom setRegions: 950)
;;;		)
;;;		(AddMenu { \01_}
;;;			{About LSL3`^a:Help`#1}
;;;		)
;;;		(AddMenu { File_}
;;;			{Save Game`#5:Restore Game`#7:Auto Save`#4:--! :Restart Game`#9:Quit`^q}
;;;		)
;;;		(AddMenu { Action_}
;;;			{Pause Game`^p:Inventory`^I:Retype`#3:--! :Colors`^c:--! :Boss Key`^b :Expletive`^x}
;;;		)
;;;		(AddMenu { Speed_}
;;;			{Change...`^s:--!:Faster`+:Normal`=:Slower`-}
;;;		)
;;;		(AddMenu { Sound_}
;;;			{Volume...`^v:Turn Off`#2=1}
;;;		)
;;;		(SetMenu
;;;			soundI p_text (if (DoSound SoundOn) {Turn Off} else {Turn On})
;;;		)
;;;		(if (< (Graph GDetect) 9)
;;;			;if CGA, disable the colors option
;;;			(SetMenu colorsI #state FALSE)
;;;		else
;;;			(SetMenu colorsI p_said '/color')
;;;		)
;;;		(SetMenu saveI p_said 'save[/game]')
;;;		(SetMenu restoreI p_said 'restore[/game]')
;;;		(SetMenu restartI p_said 'restart[/game]')
;;;		(SetMenu quitI p_said 'done[/game]')
;;;		(SetMenu pauseI p_said 'delay[/game]')
;;;		(SetMenu invI p_said 'all')
	)
	
	(method (handleEvent event &tmp temp0 i newTextColor newBackColor [str 220])
		(super handleEvent: event)
;;;		(switch event
;;;			($101 ;MENU_ABOUT 
;;;;;;				(Print "PnC Template Game" #title "About") ;ENGLISH
;;;				(Print "PnC Template Game" #title "About") ;Spanish
;;;			)
;;;			(sierraM ;MENU_ABOUT 
;;;;;;				(Print "PnC Template Game" #title "About") ;ENGLISH
;;;				(Print "PnC Template Game" #title "About") ;Spanish
;;;			)			
;;;		)
	)
)