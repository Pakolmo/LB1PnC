;;;;;; Sierra Script 1.0 - (do not remove this comment)
;;;;;;;
;;;;;;;	SAVE.SC
;;;;;;;	(c) Sierra On-Line, Inc, 1988
;;;;;;;
;;;;;;;	Author: Jeff Stephenson
;;;;;;;
;;;;;;;	Classes which create the save/restore game user interface.  Also
;;;;;;;	contains a number of instances of Dialogs and associated DItems
;;;;;;;	used in the interface.
;;;;;;;
;;;;;;;	Classes:
;;;;;;;		SRDialog
;;;;;;;		Save
;;;;;;;		Restore
;;;
;;;
;;;
;;;(script# SAVE)
;;;(include game.sh)
;;;(use Main)
;;;(use Intrface)
;;;(use Window)
;;;(use System)
;;;
;;;
;;;(define	GAMESSHOWN 8)		;the number of games displayed in the selector
;;;(define	MAXGAMES 20)		;maximum number of games in a save directory
;;;(define	COMMENTSIZE 36)		;size of user's description of the game
;;;(define COMMENTBUFF 18) 	;(define	COMMENTBUFF (/ (+ 1 COMMENTSIZE) 2))
;;;
;;;(define	DIRECTORYSIZE 29) ;size of the save directory name
;;; ;(define	DIRECTORYBUFF (/ (+ 1 DIRECTORYSIZE) 2))
;;;
;;;(define BUFFERSIZE 361) ;(define	BUFFERSIZE (+ (* MAXGAMES COMMENTBUFF) 1))
;;;
;;;
;;;;;;(procedure
;;;;;;	GetDirectory
;;;;;;	HaveSpace
;;;;;;	GetStatus
;;;;;;	NeedDescription
;;;;;;)
;;;
;;;
;;;(public
;;;	GetDirectory	0
;;;)
;;;
;;;;;;(define noRoomMsg
;;;;;;	{This directory/disk can hold no more saved games. 
;;;;;;	You must replace one of your saved games or use
;;;;;;	Change Directory to save on a different directory/disk.}
;;;;;;)
;;;
;;;
;;;(local
;;;	default
;;;	i
;;;	numGames
;;;	selected
;;;	status
;;;;;;	okIText = [{Restore} {__Save__} {Replace} {Replace}]
;;;;;;	textIText = [
;;;;;;					{Select the game that you would like to restore.}
;;;;;;					{Type the description of this saved game.}
;;;;;;					{This directory/disk can hold no more saved games. 
;;;;;;	You must replace one of your saved games or use
;;;;;;	Change Directory to save on a different directory/disk.}
;;;;;;					{This directory/disk can hold no more saved games. 
;;;;;;	You must replace one of your saved games or use
;;;;;;	Change Directory to save on a different directory/disk.}
;;;;;;					]
;;;	okIText = [{Restaurar} {__Salvar__} {Reemplazar} {Reemplazar}]
;;;	textIText = [
;;;					{Selecciona el juego que quieres cargar.}
;;;					{Escribe la descripci/n de esta partida guardada.}
;;;					{Este directorio o disco no puede contener m*s partidas guardadas. 
;;;	Debes sustituir una de tus partidas guardadas o Cambiar
;;;	el directorio para guardar en un directorio o disco diferente.}
;;;					{Este directorio o disco no puede contener m*s partidas guardadas. 
;;;	Debes sustituir una de tus partidas guardadas o Cambiar
;;;	el directorio para guardar en un directorio o disco diferente.}
;;;					]					
;;;
;;;
;;;
;;;
;;;)
;;;
;;;
;;;
;;;(enum
;;;	RESTORE			;Restore games
;;;	HAVESPACE		;Save, with space on disk
;;;	NOSPACE			;Save, no space on disk but games to replace
;;;	NOREPLACE		;Save, no space on disk, no games to replace
;;;)
;;;
;;;
;;;(class SysWindow kindof	Object
;;;	(properties
;;;		top		0
;;;		left		0
;;;		bottom	0
;;;		right		0
;;;		color		0			; foreground color
;;;		back		15			; background color
;;;		priority	-1			; priority
;;;		window	0			; handle/pointer to system window
;;;		type	0				; generally	corresponds to system window types
;;;		title		0			; text appearing in title bar if present
;;;
;;;		;; this rectangle is the working area for X/Y centering
;;;		;; these coordinates can define a subsection of the picture
;;;		;; in which a window will be centered
;;;		brTop		0
;;;		brLeft	0
;;;		brBottom	190
;;;		brRight	320
;;;	)
;;;
;;;;;;	(methods
;;;;;;		open
;;;;;;		dispose
;;;;;;	)
;;;
;;;	;; Open corresponding system window structure
;;;	;; Custom window type 0x81 indicates that system
;;;	;; will NOT draw the window, only get a port and link into list
;;;	(method (open)
;;;		(= window 
;;;			(NewWindow 
;;;				top 
;;;				left 
;;;				bottom 
;;;				right 
;;;				title 
;;;				type
;;;				priority 
;;;				color
;;;				back
;;;			)
;;;		)
;;;	)
;;;	(method (dispose)
;;;		(if window
;;;			(DisposeWindow window)
;;;			(= window 0)
;;;		)
;;;		(super dispose:)
;;;	)
;;;)
;;;
;;;
;;;
;;;(class SRDialog kindof Dialog
;;;	;;; The SRDialog class implements the user interface for save/restore.
;;;	;;; Its subclasses are the specific save and restore game dialogs,
;;;	;;; Save and Restore.
;;;
;;;	(method (init theComment names nums)
;;;		;; Initialize the dialog.
;;;
;;;
;;;		; give ourself the class SysWindow as our window
;;;		(= window SysWindow)
;;;
;;;		;Re-init our size, with no elements.
;;;		(= nsBottom 0)
;;;
;;;		;Get some files for this directory.
;;;		(= numGames (GetSaveFiles (theGame name?) names nums))
;;;		(if (== numGames -1)
;;;			(return FALSE)
;;;		)
;;;
;;;		(= status (GetStatus))
;;;
;;;		;Set up the edit item for saved games.
;;;		(if (== status HAVESPACE)
;;;			(editI
;;;				text: (StrCpy theComment names),
;;;				font: smallFont,
;;;				setSize:,
;;;				moveTo: MARGIN MARGIN
;;;			)
;;;			(self add: editI, setSize:)
;;;		)
;;;
;;;		;Set up the selectorI box.
;;;		(selectorI
;;;			text: names,
;;;			font: smallFont,
;;;			setSize:,
;;;			moveTo: MARGIN (+ nsBottom MARGIN),
;;;			state: dExit
;;;		)
;;;
;;;		;Add three buttons down the side.
;;;		(= i (+ (selectorI nsRight?) MARGIN))
;;;		(okI
;;;			text: [okIText status],
;;;			setSize:,
;;;			moveTo: i (selectorI nsTop?),
;;;			state:(if (== status NOREPLACE) 0 else (| dActive dExit))
;;;		)
;;;		(cancelI
;;;			setSize:,
;;;			moveTo: i (+ (okI nsBottom?) MARGIN),
;;;			state: (& (cancelI state?) (~ dSelected))
;;;		)
;;;		(changeDirI
;;;			setSize:,
;;;			moveTo: i (+ (cancelI nsBottom?) MARGIN),
;;;			state: (& (changeDirI state?) (~ dSelected))
;;;		)
;;;
;;;		;Put these elements into the dialog and size it.
;;;		(self
;;;			add: selectorI okI cancelI changeDirI,
;;;			setSize:
;;;		)
;;;
;;;		;Use the width of the dialog to size the text which goes into it.
;;;		(textI
;;;			text: [textIText status],
;;;			setSize: (- (- nsRight nsLeft) (* 2 MARGIN)),
;;;			moveTo: MARGIN MARGIN
;;;		)
;;;
;;;		;Now move all elements down by the height of the text.
;;;		(= i (+ (textI nsBottom?) MARGIN))
;;;		(self eachElementDo: #move: 0 i)
;;;
;;;		;Add the text to the dialog, and resize.
;;;		(self
;;;			add: textI,
;;;			setSize:, 
;;;			center:,
;;;			open: wTitled 15
;;;		)
;;;
;;;		(return TRUE)
;;;	)
;;;
;;;
;;;
;;;
;;;	(method	(doit theComment
;;;						&tmp 	oldStatus fd ret offset
;;;								[names BUFFERSIZE] [nums 21]
;;;								[str 40]
;;;				)
;;;
;;;		;If restore: is called with a TRUE parameter, do nothing if there
;;;		;are no saved games.  This allows optionally presenting the user
;;;		;with his saved games at the start of the game.
;;;		(if
;;;			(and
;;;				(== self Restore)
;;;				argc
;;;				theComment
;;;			)
;;;
;;;			(= fd (FOpen (Format @str SAVE 0 (theGame name?))))
;;;			(if (== fd -1)
;;;				;no directory -> no saved games
;;;				(return)
;;;			)
;;;			(FClose fd)
;;;		)
;;;
;;;		(if (not (self init: theComment @names @nums))
;;;			(return -1)
;;;		)
;;;
;;;		(repeat
;;;			(= default
;;;				(switch status
;;;					(RESTORE
;;;						(if numGames okI else changeDirI)
;;;					)
;;;					(HAVESPACE
;;;						;Edit item of save games is active if present
;;;						editI
;;;					)
;;;					(NOSPACE
;;;						;If there are save-games to replace, 'Replace'
;;;						;button is active.
;;;						okI
;;;					)
;;;					(else
;;;						;Otherwise 'Change Directory' button is active.
;;;						changeDirI
;;;					)
;;;				)
;;;			)
;;;
;;;			(= i (super doit: default))
;;;
;;;			(= selected (selectorI indexOf: (selectorI cursor?)))
;;;			(= offset (* selected COMMENTBUFF))
;;;			(cond
;;;				((== i changeDirI)
;;;					(if (GetDirectory curSaveDir)
;;;						(= numGames
;;;							(GetSaveFiles (theGame name?) @names @nums)
;;;						)
;;;						(if (== numGames -1)
;;;							(= ret -1)
;;;							(break)
;;;						)
;;;
;;;						(= oldStatus status)
;;;						(= status (GetStatus))
;;;						(switch status
;;;							(RESTORE
;;;							)
;;;							(oldStatus
;;;								(if (self contains: editI)
;;;									(editI
;;;										cursor: (StrLen (StrCpy theComment @names)),
;;;										draw:
;;;									)
;;;								)
;;;							)
;;;							(else
;;;								(self
;;;									dispose:,
;;;									init: theComment @names @nums
;;;								)
;;;							)
;;;						)
;;;
;;;						(selectorI draw:)
;;;					)
;;;				)
;;;
;;;				((and (== status NOSPACE) (== i okI))
;;;					(if (GetReplaceName doit: (StrCpy theComment @[names offset]))
;;;						(= ret [nums selected])
;;;						(break)
;;;					)
;;;				)
;;;
;;;				((and (== status HAVESPACE) (or (== i okI) (== i editI)))
;;;					(if (== (StrLen theComment) 0)
;;;						(NeedDescription)
;;;						(continue)
;;;					)
;;;
;;;					(= ret -1)
;;;					(for	((= i 0))
;;;							(< i numGames)
;;;							((++ i))
;;;
;;;						(= ret (StrCmp theComment @[names (* i COMMENTBUFF)]))
;;;						(breakif (not ret))
;;;					)
;;;
;;;					(= ret
;;;						(cond
;;;							((not ret)
;;;								[nums i]
;;;							)
;;;							((== numGames MAXGAMES)
;;;								[nums selected]
;;;							)
;;;							(else
;;;								numGames
;;;							)
;;;						)
;;;					)
;;;					(break)
;;;				)
;;;
;;;				((== i okI)
;;;					(= ret [nums selected])
;;;					(break)
;;;				)
;;;
;;;				((or (== i 0) (== i cancelI))
;;;					(= ret -1)
;;;					(break)
;;;				)
;;;
;;;				((== status HAVESPACE)
;;;					(editI
;;;						cursor:
;;;							(StrLen (StrCpy theComment @[names offset])),
;;;						draw:
;;;					)
;;;				)
;;;			)
;;;		)
;;;
;;;		(self dispose:)
;;;		(return ret)
;;;	)
;;;
;;;
;;;
;;;	(procedure (GetStatus)
;;;		(return
;;;			(cond
;;;				((== self Restore)
;;;					RESTORE
;;;				)
;;;				((HaveSpace)
;;;					HAVESPACE
;;;				)
;;;				(numGames
;;;					NOSPACE
;;;				)
;;;				(else
;;;					NOREPLACE
;;;				)
;;;			)
;;;		)
;;;	)
;;;)
;;;
;;;
;;;
;;;(class Restore of SRDialog
;;;	(properties
;;;;;;		text "Restore a Game"
;;;		text "Cargar un Juego" ;Spanish
;;;	)
;;;)
;;;
;;;
;;;(class Save of SRDialog
;;;	(properties
;;;;;;		text "Save a Game"
;;;		text "Salvar un Juego" ;Spanish
;;;	)
;;;)
;;;
;;;
;;;
;;;(instance GetReplaceName of Dialog
;;;
;;;	(method (doit theComment &tmp ret)
;;;		; give ourself the class SysWindow as our window
;;;		(= window SysWindow)
;;;
;;;		(text1
;;;			setSize:,
;;;			moveTo:MARGIN MARGIN
;;;		)
;;;		(self add:text1, setSize:)
;;;		(oldName
;;;			text: theComment,
;;;			font: smallFont,
;;;			setSize:,
;;;			moveTo:MARGIN nsBottom
;;;		)
;;;		(self add:oldName, setSize:)
;;;		(text2
;;;			setSize:,
;;;			moveTo:MARGIN nsBottom
;;;		)
;;;		(self add:text2, setSize:)
;;;		(newName
;;;			text: theComment,
;;;			font: smallFont,
;;;			setSize:,
;;;			moveTo: MARGIN nsBottom
;;;		)
;;;		(self add:newName, setSize:)
;;;
;;;		(button1 nsLeft:0, nsTop:0, setSize:)
;;;		(button2 nsLeft:0, nsTop:0, setSize:)
;;;		(button2
;;;			moveTo:
;;;				(-	nsRight (+ (button2 nsRight?) MARGIN))
;;;				nsBottom
;;;		)
;;;		(button1
;;;			moveTo:
;;;				(- (button2 nsLeft?) (+ (button1 nsRight?) MARGIN))
;;;				nsBottom
;;;		)
;;;
;;;		(self
;;;			add:button1 button2,
;;;			setSize:,
;;;			center:, 
;;;			open:stdWindow 15
;;;		)
;;;
;;;		(= ret (super doit:newName))
;;;		(self dispose:)
;;;		(if (not (StrLen theComment))
;;;			(NeedDescription)
;;;			(= ret 0)
;;;		)
;;;
;;;		(return (or (== ret newName) (== ret button1)))
;;;	)
;;;)
;;;
;;;
;;;
;;;(procedure (GetDirectory where &tmp result [newDir 33] [str 40])
;;;	(repeat
;;;		(= result
;;;			(Print 
;;;				SAVE 1
;;;				#font: SYSFONT
;;;				#edit: (StrCpy @newDir where) DIRECTORYSIZE
;;;				#button: {OK} 1
;;;;;;				#button: {Cancel} 0 ;english
;;;				#button: {Cancelar} 0 ;spanish
;;;			)
;;;		)
;;;
;;;		;Pressed ESC -- return FALSE.
;;;		(if (not result)
;;;			(return FALSE)
;;;		)
;;;
;;;		;No string defaults to current drive.
;;;		(if (not (StrLen @newDir))
;;;			(GetCWD @newDir)
;;;		)
;;;
;;;		;If drive is valid, return TRUE, otherwise complain.
;;;		(if (ValidPath @newDir)
;;;			(StrCpy where @newDir)
;;;			(return TRUE)
;;;		else
;;;			(Print
;;;				(Format @str SAVE 2 @newDir)
;;;				#font:SYSFONT
;;;			)
;;;		)
;;;	)
;;;)
;;;
;;;
;;;
;;;(procedure (HaveSpace)
;;;	(return (and (< numGames MAXGAMES) (CheckFreeSpace curSaveDir)))
;;;)
;;;
;;;
;;;
;;;(procedure (NeedDescription)
;;;	(Print SAVE 3 #font:SYSFONT)
;;;)
;;;
;;;
;;;
;;;(instance selectorI of DSelector
;;;	(properties
;;;		x COMMENTSIZE 
;;;		y GAMESSHOWN
;;;	)
;;;)
;;;(instance editI of DEdit
;;;	(properties
;;;		max (- COMMENTSIZE 1)
;;;	)
;;;)
;;;(instance okI of DButton
;;;)
;;;(instance cancelI of DButton
;;;	(properties
;;;;;;		text "_Cancel_"
;;;		text "_Cancelar_" ;spanish		
;;;	)
;;;)
;;;(instance changeDirI of DButton
;;;	(properties
;;;;;;		text {Change\nDirectory}
;;;		text {Cambiar\nDirectorio} ;spanish
;;;	)
;;;)
;;;(instance textI of DText
;;;	(properties
;;;		font SYSFONT
;;;	)
;;;)
;;;
;;;
;;;(instance text1 of DText
;;;	(properties
;;;		font SYSFONT
;;;;;;		text "Replace"
;;;		text "Reemplazar" ;spanish
;;;	)
;;;)
;;;(instance text2 of DText
;;;	(properties
;;;		font SYSFONT
;;;;;;		text "with:"
;;;		text "con:" ;spanish
;;;	)
;;;)
;;;(instance oldName of DText
;;;)
;;;(instance newName of DEdit
;;;	(properties
;;;		max (- COMMENTSIZE 1)
;;;	)
;;;)
;;;(instance button1 of DButton
;;;	(properties
;;;;;;		text "Replace" ;english
;;;		text "Reemplazar"	 ;spanish
;;;	)
;;;)
;;;(instance button2 of DButton
;;;	(properties
;;;;;;		text "Cancel" ;english
;;;		text "Cancelar" ;spanish
;;;	)
;;;)
;;;
;;;
;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use intrface)
(use Window)

(public
	proc990_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
;;;	[local5 4] = [{Restore} {__Save__} {Replace} {Replace}]
;;;	[local9 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
	[local5 4] = [{ Cargar} { Guardar} {Guardar} {Guardar}]
	[local9 4] = [{Elige el juego que te gustar-a cargar._________} {Escribe una descripci/n para el juego.__} {Esta carpeta o disco no puede guardar m*s juegos. Debes reemplazar uno de los juegos existentes o cambiar la carpeta para guardarlos en un lugar distinto} {Esta carpeta o disco no puede guardar m*s juegos. Debes reemplazar uno de los juegos existentes o cambiar la carpeta para guardarlos en un lugar distinto}]
)


(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 40])
	(asm
code_06a4:
		pushi    13
		pushi    990
		pushi    1
		pushi    33
		pushi    0
		pushi    41
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    81
		lofsa    {OK}
		push    
		pushi    1
		pushi    81
		lofsa    {Cancelar}
		push    
		pushi    0
		calle    Print,  26
		sat      temp0
		not     
		bnt      code_06d7
		ldi      0
		ret     
code_06d7:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_06eb
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_06eb:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_0706
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_06a4
code_0706:
		pushi    3
		pushi    4
		lea      @temp34
		push    
		pushi    990
		pushi    2
		lea      @temp1
		push    
		callk    Format,  8
		push    
		pushi    33
		pushi    0
		calle    Print,  6
		jmp      code_06a4
		ret     
	)
)

(procedure (localproc_0407)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_0725) 1)
			(local2 2)
			(else 3)
		)
	)
)

(procedure (localproc_0725)
	(if (< local2 20) (CheckFreeSpace curSaveDir))
)

(procedure (localproc_0734)
	(Print 990 3 33 0)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
	
	(method (init param1 param2 param3)
		(= window SysWindow)
		(= nsBottom 0)
		(if
			(==
				(= local2 (GetSaveFiles (theGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local4 (localproc_0407)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: smallFont
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: param2
			font: smallFont
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= local1 (+ (selectorI nsRight?) 4))
		(okI
			text: [local5 local4]
			setSize:
			moveTo: local1 (selectorI nsTop?)
			state: (if (== local4 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: local1 (+ (okI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: local1 (+ (cancelI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)
		(self add: selectorI okI cancelI changeDirI setSize:)
		(textI
			text: [local9 local4]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local1)
		(self add: textI setSize: center: open: 4 15)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 [temp4 361] [temp365 21] [temp386 40])
		(asm
			pushSelf
			class    Restore
			eq?     
			bnt      code_01d8
			lap      argc
			bnt      code_01d8
			lap      param1
			bnt      code_01d8
			pushi    1
			pushi    4
			lea      @temp386
			push    
			pushi    990
			pushi    0
			pushi    #name
			pushi    0
			lag      theGame
			send     4
			push    
			callk    Format,  8
			push    
			callk    FOpen,  2
			sat      temp1
			push    
			ldi      65535
			eq?     
			bnt      code_01d2
			ret     
code_01d2:
			pushi    1
			lst      temp1
			callk    FClose,  2
code_01d8:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     10
			not     
			bnt      code_01f1
			ldi      65535
			ret     
code_01f1:
			lsl      local4
			dup     
			ldi      0
			eq?     
			bnt      code_020b
			lal      local2
			bnt      code_0228
			lofsa    okI
			jmp      code_0228
			lofsa    changeDirI
			jmp      code_0228
code_020b:
			dup     
			ldi      1
			eq?     
			bnt      code_0218
			lofsa    editI
			jmp      code_0228
code_0218:
			dup     
			ldi      2
			eq?     
			bnt      code_0225
			lofsa    okI
			jmp      code_0228
code_0225:
			lofsa    changeDirI
code_0228:
			toss    
			sal      local0
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local1
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local3
			push    
			ldi      18
			mul     
			sat      temp3
			lsl      local1
			lofsa    changeDirI
			eq?     
			bnt      code_02ef
			pushi    1
			lsg      curSaveDir
;;;			call     localproc_06a2,  2
			call     proc990_0, 2
			bnt      code_01f1
			pushi    3
			pushi    #name
			pushi    0
			lag      theGame
			send     4
			push    
			lea      @temp4
			push    
			lea      @temp365
			push    
			callk    GetSaveFiles,  6
			sal      local2
			push    
			ldi      65535
			eq?     
			bnt      code_0287
			ldi      65535
			sat      temp2
			jmp      code_03ff
code_0287:
			lal      local4
			sat      temp0
			pushi    0
			call     localproc_0407,  0
			sal      local4
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_029d
			jmp      code_02e3
code_029d:
			dup     
			lat      temp0
			eq?     
			bnt      code_02ce
			pushi    #contains
			pushi    1
			lofsa    editI
			push    
			self     6
			bnt      code_02e3
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lea      @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_02e3
code_02ce:
			pushi    #dispose
			pushi    0
			pushi    87
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     14
code_02e3:
			toss    
			pushi    #draw
			pushi    0
			lofsa    selectorI
			send     4
			jmp      code_01f1
code_02ef:
			lsl      local4
			ldi      2
			eq?     
			bnt      code_0325
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_0325
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_01f1
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_03ff
			jmp      code_01f1
code_0325:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_03a6
			lsl      local1
			lofsa    okI
			eq?     
			bt       code_033f
			lsl      local1
			lofsa    editI
			eq?     
			bnt      code_03a6
code_033f:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0354
			pushi    0
			call     localproc_0734,  0
			jmp      code_01f1
code_0354:
			ldi      65535
			sat      temp2
			ldi      0
			sal      local1
code_035c:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_037e
			pushi    2
			lsp      param1
			lsl      local1
			ldi      18
			mul     
			leai     @temp4
			push    
			callk    StrCmp,  4
			sat      temp2
			not     
			bnt      code_0379
code_0379:
			+al      local1
			jmp      code_035c
code_037e:
			lat      temp2
			not     
			bnt      code_038c
			lal      local1
			lati     temp365
			jmp      code_039e
code_038c:
			lsl      local2
			ldi      20
			eq?     
			bnt      code_039c
			lal      local3
			lati     temp365
			jmp      code_039e
code_039c:
			lal      local2
code_039e:
			sat      temp2
			jmp      code_03ff
			jmp      code_01f1
code_03a6:
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_03bc
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_03ff
			jmp      code_01f1
code_03bc:
			lsl      local1
			ldi      0
			eq?     
			bt       code_03cd
			lsl      local1
			lofsa    cancelI
			eq?     
			bnt      code_03d7
code_03cd:
			ldi      65535
			sat      temp2
			jmp      code_03ff
			jmp      code_01f1
code_03d7:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_01f1
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_01f1
code_03ff:
			pushi    #dispose
			pushi    0
			self     4
			lat      temp2
			ret     
		)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
;;;		text {Restore a Game}
		text {Restaurar un Juego}		
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
;;;		text {Save a Game}
		text {Salvar un Juego}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0)
		(= window SysWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: smallFont
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: smallFont
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 15)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_0734)
			(= temp0 0)
		)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties
		text { Cancelar_}
	)
)

(instance changeDirI of DButton
	(properties
		text {Cambiar\0D\nDirectorio}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {Reemplazar}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {con:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {Reemplazar}
	)
)

(instance button2 of DButton
	(properties
		text {Cancelar}
	)
)
