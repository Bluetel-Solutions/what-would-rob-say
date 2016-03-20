@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  what-would-rob-say startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and WHAT_WOULD_ROB_SAY_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\what-would-rob-say.jar;%APP_HOME%\lib\dropwizard-core-0.6.2.jar;%APP_HOME%\lib\dropwizard-hibernate-0.6.2.jar;%APP_HOME%\lib\dropwizard-migrations-0.6.2.jar;%APP_HOME%\lib\dropwizard-auth-0.6.2.jar;%APP_HOME%\lib\h2-1.3.168.jar;%APP_HOME%\lib\jersey-core-1.17.1.jar;%APP_HOME%\lib\jersey-server-1.17.1.jar;%APP_HOME%\lib\jersey-servlet-1.17.1.jar;%APP_HOME%\lib\metrics-core-2.2.0.jar;%APP_HOME%\lib\metrics-servlet-2.2.0.jar;%APP_HOME%\lib\metrics-jetty-2.2.0.jar;%APP_HOME%\lib\metrics-logback-2.2.0.jar;%APP_HOME%\lib\metrics-jersey-2.2.0.jar;%APP_HOME%\lib\jackson-databind-2.1.4.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.1.4.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.1.4.jar;%APP_HOME%\lib\jackson-datatype-guava-2.1.2.jar;%APP_HOME%\lib\argparse4j-0.4.0.jar;%APP_HOME%\lib\slf4j-api-1.7.4.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.4.jar;%APP_HOME%\lib\logback-core-1.0.10.jar;%APP_HOME%\lib\logback-classic-1.0.10.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.4.jar;%APP_HOME%\lib\jetty-server-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-servlet-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-http-8.1.10.v20130312.jar;%APP_HOME%\lib\guava-14.0.1.jar;%APP_HOME%\lib\jsr305-2.0.1.jar;%APP_HOME%\lib\hibernate-validator-4.3.1.Final.jar;%APP_HOME%\lib\joda-time-2.2.jar;%APP_HOME%\lib\jackson-datatype-joda-2.1.2.jar;%APP_HOME%\lib\dropwizard-db-0.6.2.jar;%APP_HOME%\lib\jackson-datatype-hibernate4-2.1.2.jar;%APP_HOME%\lib\usertype.core-3.0.0.GA.jar;%APP_HOME%\lib\hibernate-core-4.1.9.Final.jar;%APP_HOME%\lib\liquibase-core-2.0.5.jar;%APP_HOME%\lib\liquibase-slf4j-1.0.0.jar;%APP_HOME%\lib\asm-3.1.jar;%APP_HOME%\lib\metrics-annotation-2.2.0.jar;%APP_HOME%\lib\jackson-core-2.1.4.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.1.4.jar;%APP_HOME%\lib\jetty-security-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-io-8.1.10.v20130312.jar;%APP_HOME%\lib\validation-api-1.0.0.GA.jar;%APP_HOME%\lib\tomcat-dbcp-7.0.37.jar;%APP_HOME%\lib\usertype.spi-3.0.0.GA.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\javassist-3.17.1-GA.jar;%APP_HOME%\lib\jboss-transaction-api_1.1_spec-1.0.0.Final.jar;%APP_HOME%\lib\dom4j-1.6.1.jar;%APP_HOME%\lib\hibernate-jpa-2.0-api-1.0.1.Final.jar;%APP_HOME%\lib\hibernate-commons-annotations-4.0.1.Final.jar;%APP_HOME%\lib\jetty-util-8.1.10.v20130312.jar;%APP_HOME%\lib\jackson-annotations-2.1.4.jar;%APP_HOME%\lib\javax.servlet-3.0.0.v201112011016.jar;%APP_HOME%\lib\jetty-continuation-8.1.10.v20130312.jar;%APP_HOME%\lib\jboss-logging-3.1.0.GA.jar

@rem Execute what-would-rob-say
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %WHAT_WOULD_ROB_SAY_OPTS%  -classpath "%CLASSPATH%" uk.co.bluetel.Application %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable WHAT_WOULD_ROB_SAY_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%WHAT_WOULD_ROB_SAY_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
