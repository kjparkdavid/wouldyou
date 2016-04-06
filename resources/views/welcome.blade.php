<!DOCTYPE html>
<html>
    <head>
        <title>Would You</title>

        <link href="https://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    </head>
    <body>
      @if (Session::has('message'))
    	<div class="alert alert-success alert-dismissable">
    		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>{{ Session::get('message') }}
    	</div>

    @endif
        <div class="container">
          <div class="row">
        		<div class="col-md-12">
              <div class="well" style="margin-bottom:40px;">
                  <h1 class="intro" style="margin-bottom:0px;">Would You</h1>
                  <h3 class="subtitle">ADMIN PAGE</h3>
                  <a href="mailto:kjparkdavid@gmail.com" target="_blank"><span class="btn btn-md btn-primary">Edit Page</span></a>
                  <a href="/portfolio"><span class="btn btn-md btn-primary">Add Date Courses</span></a>
                </div>
            </div>


            <div class="row">
            		<div class="col-md-12 text-center">
            		    <h3>Date Courses<h3>
                    @foreach($courses as $f)
                    <div class="col-md-4" style="text-align:left;">
                      <h4 style ="color:red">{!! $f -> name !!}</h4>
                      <div class="well footprint" style="text-align:left;">
                        <h5>{!! $f -> image !!}</h5>
                      <!--  <h6>- {{ Carbon\Carbon::createFromFormat('Y-m-d H:i:s', $f->created_at)->format("M/d/Y") }}</h6>-->
                      </div>
                    </div>
                    @endforeach

            		</div>
            </div>

            <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">

      {!! Form::open(array('action' => array('MainController@createDC'), 'method' => 'post', 'class' => 'form-horizontal','id' => 'course-creator','role' => 'form')) !!}
      <div class = "form-group">
        <div class = "col-sm-12">
          {!! Form::text('name', null, array('class' => 'form-control', 'id' => 'name', 'placeholder' => "Name", 'required')) !!}
        </div>
      </div>
      <div class ="form-group">
        <div class = "col-sm-12">
          {!! Form::text('image', null, array('class' => 'form-control', 'id' => 'image', 'placeholder' => "Image URL")) !!}
        </div>
      </div>
      
      {!! Form::submit('Post', array('class' => 'btn btn-success')) !!}
      {!! Form::close() !!}
    </div>
    <div class="col-md-2"></div>
  </div>

          </div>
        </div>
    </body>
</html>
